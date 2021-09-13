package edu.uclm.esi.tys2122.services;

import java.util.Optional;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.uclm.esi.tys2122.dao.LoginRepository;
import edu.uclm.esi.tys2122.http.Manager;
import edu.uclm.esi.tys2122.model.Email;
import edu.uclm.esi.tys2122.model.Login;
import edu.uclm.esi.tys2122.model.Token;
import edu.uclm.esi.tys2122.model.User;

@Service
public class UserService {
	@Autowired
	private LoginRepository loginDAO;
	
	public void save(User user) {
		Manager.get().getUsersRepository().save(user);
		
		Token token = new Token(user.getEmail());
		Manager.get().getTokensRepository().save(token);
		Email smtp=new Email();
		smtp.send(user.getEmail(), "Bienvenido al sistema", 
			"Para confirmar, pulse aquí: " +
			"http://localhost/user/validateAccount/" + token.getId());

	}

	public void validateToken(String tokenId) {
		Optional<Token> optToken = Manager.get().getTokensRepository().findById(tokenId);
		if (optToken.isPresent()) {
			Token token = optToken.get();
			long date = token.getDate();
			long now = System.currentTimeMillis();
			if (now>date+24*60*60*1000)
				throw new ResponseStatusException(HttpStatus.GONE, "Token caducado");
			String email = token.getEmail();
			User user = Manager.get().getUsersRepository().findByEmail(email);
			if (user!=null) {
				user.setConfirmationDate(now);
				Manager.get().getUsersRepository().save(user);
			} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Token " + tokenId + " no encontrado");
	}

	public void insertLogin(User user, String ip, Cookie cookie) {
		Login login = new Login();
		login.setEmail(user.getEmail());
		login.setDate(System.currentTimeMillis());
		login.setIp(ip);
		login.setCookieValue(cookie.getValue());
		loginDAO.save(login);
	}
}
