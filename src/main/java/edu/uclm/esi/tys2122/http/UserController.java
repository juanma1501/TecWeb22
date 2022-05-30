package edu.uclm.esi.tys2122.http;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uclm.esi.tys2122.model.Email;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import edu.uclm.esi.tys2122.model.User;
import edu.uclm.esi.tys2122.services.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController extends CookiesController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
	public void login(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> credenciales) {
		JSONObject jso = new JSONObject(credenciales);
		if (jso.optString("type").equals("google")) {
			loginWithGoogle(request, response, jso);
		} else {
			normalLogin(request, response, jso);
		}
	}

	private void normalLogin(HttpServletRequest request, HttpServletResponse response, JSONObject jso) {
		String name = jso.getString("name");
		String pwd = jso.getString("pwd");
		String ip = request.getRemoteAddr();
		User user = userService.doLogin(name, pwd, ip);
		loguearse(request, response, ip, user);
	}

	private void loguearse (HttpServletRequest request, HttpServletResponse response, String ip, User user) {
		Cookie cookie = readOrCreateCookie(request, response);
		user.setCookie(cookie.getValue());
		Manager.get().getUserRepository().save(user);
		userService.insertLogin(user, ip, cookie);
		request.getSession().setAttribute("user", user);
		Manager.get().add(request.getSession());
	}

	private void loginWithGoogle(HttpServletRequest request, HttpServletResponse response, JSONObject jso) {
		String name = jso.getString("name");
		String email = jso.getString("email");
		String id = jso.getString("id");
		String ip = request.getRemoteAddr();

		Optional<User> userDB = Manager.get().getUserRepository().findById(id);
		if (userDB.isPresent()) {
			User user = userDB.get();
			loguearse(request, response, ip, user);
		} else {
			User userByEmail = Manager.get().getUserRepository().findByEmail(email);
			if (userByEmail != null) {
				loguearse(request, response, ip, userByEmail);
			} else {
				User newUser = new User(id, name, email);
				loguearse(request, response, ip, newUser);
			}
		}
	}

	@PutMapping("/register")
	@ResponseBody
	public String register(@RequestBody Map<String, Object> credenciales) {
		JSONObject jso = new JSONObject(credenciales);
		String userName = jso.optString("userName");
		String email = jso.optString("email");
		String pwd1 = jso.optString("pwd1");
		String pwd2 = jso.optString("pwd2");
		String picture = jso.optString("picture");		
		if (!pwd1.equals(pwd2))
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Error: las contraseñas no coinciden");
		if (pwd1.length()<4)
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Error: la contraseña debe tener al menos cuatro caracteres");


			if (Manager.get().getUserRepository().findByEmail(email) != null){
				throw new ResponseStatusException(HttpStatus.CONFLICT, "El usuario que intentas crear ya existe. Introuce otro mail");
			}else{
				User user = new User();
				user.setName(userName);
				user.setEmail(email);
				user.setPwd(pwd1);
				user.setPicture(picture);

				userService.save(user);
				return "Te hemos enviado un correo para confirmar tu registro";
			}
	}
	
	@DeleteMapping("/remove/{userId}")
	public void remove(@PathVariable String userId) {
		System.out.println("Borrar el usuario con id " + userId);		
	}
	
	@GetMapping("/validateAccount/{tokenId}")
	public void validateAccount(HttpServletRequest request, HttpServletResponse response, @PathVariable String tokenId) {
		userService.validateToken(tokenId);
		// Ir a la base de datos, buscar el token con ese tokenId en la tabla, ver que no ha caducado
		// y actualizar la confirmationDate del user
		System.out.println(tokenId);
		try {
			response.sendRedirect(Manager.get().getConfiguration().getString("home"));
		} catch (IOException e) {
			
		}
	}

	@PostMapping(value = "/resetPassword")
	public String resetPassword(HttpServletRequest request, @RequestBody Map<String, Object> credenciales) {
		sendEmailRecovery(credenciales);
		return "Revisa tu correo electrónico, allí encontrarás un link para restablecer tu contraseña.";
	}

	@PostMapping(value = "/changePassword")
	public String resetPasswordToken(HttpServletRequest request, @RequestBody Map<String, Object> credenciales) {
		try {
			JSONObject jso = new JSONObject(credenciales);
			String token = jso.getString("token");
			String newPass = jso.getString("newPass");
			String newPass2 = jso.getString("newPass2");

			if (!newPass.equals(newPass2))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Las contraseñas no coinciden");

			if (newPass.length() < 4)
				throw new ResponseStatusException(HttpStatus.CONFLICT, "La contraseña debe tener al menos cuatro caracteres");

			//newPass = org.apache.commons.codec.digest.DigestUtils.sha512Hex(newPass);

			User user = null;
			try {
				user = Manager.get().getUserRepository().findByToken(token);
				Manager.get().getUserRepository().updatePwdById(newPass, user.getId());
				Manager.get().getUserRepository().deleteTokenAfterUse(user.getId());
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "No hay solicitud de cambio de contraseña para esta cuenta");
			}

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ambos campos son obligatorios");
		}

		return "Se ha recuperado tu contraseña satisfactoria";
	}


	private void sendEmailRecovery(Map<String, Object> credenciales) {
		JSONObject applicationData = Manager.get().getConfiguration();
		JSONObject emailDefaultData = Manager.get().getConfiguration().getJSONObject("email");

		JSONObject jso = new JSONObject(credenciales);
		String email = jso.getString("email");

		Email emailSender = new Email();

		if (userService.findUserByEmail(email)) {
					String auxToken = UUID.randomUUID().toString();
					emailSender.send(email, (String) emailDefaultData.get("recoveryMsgTopic"), (String) emailDefaultData.get("recoveryMsgContent") + (String) applicationData.get("home") + "/?ojr=changePassword/" + auxToken);
					Manager.get().getUserRepository().setTokenFromEmail(auxToken, email);
			}
		else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No existe ningún usuario con ese correo");
		}


	}



}
