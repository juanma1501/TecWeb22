package edu.uclm.esi.tys2122.services;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;

import edu.uclm.esi.tys2122.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.uclm.esi.tys2122.dao.LoginRepository;
import edu.uclm.esi.tys2122.dao.TokenRepository;
import edu.uclm.esi.tys2122.dao.UserRepository;
import edu.uclm.esi.tys2122.model.Login;
import edu.uclm.esi.tys2122.model.Token;
import edu.uclm.esi.tys2122.model.User;

/**
 * The type User service.
 */
@Service
public class UserService {
	@Autowired
	private LoginRepository loginDAO;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenRepository tokenRepo;
	
	private ConcurrentHashMap<String, User> connectedUsers;

	/**
	 * Instantiates a new User service.
	 */
	public UserService() {
		this.connectedUsers = new ConcurrentHashMap<>();
	}

	/**
	 * Do login user.
	 *
	 * @param name the name
	 * @param pwd  the pwd
	 * @param ip   the ip
	 * @return the user
	 */
	public User doLogin(String name, String pwd, String ip) {
		User user = userRepository.findByNameAndPwd(name, pwd);

		Iterator<ConcurrentHashMap.Entry<String, User>> itr = connectedUsers.entrySet().iterator();

		if (user==null  || user.getConfirmationDate()==null)
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Credenciales no válidas o cuenta no validada \uD83D\uDCC2");
		
		this.connectedUsers.put(user.getId(), user);
		return user;
	}

	/**
	 * Save.
	 *
	 * @param user the user
	 */
	public void save(User user) {
		userRepository.save(user);
		
		Token token = new Token(user.getEmail());
		tokenRepo.save(token);

		Email smtp=new Email();
		smtp.send(user.getEmail(), "Bienvenido al sistema \uD83D\uDCBB",
			"Para confirmar, pulse aquí: " +
			"http://localhost/user/validateAccount/" + token.getId());

	}

	/**
	 * Validate token.
	 *
	 * @param tokenId the token id
	 */
	public void validateToken(String tokenId) {
		Optional<Token> optToken = tokenRepo.findById(tokenId);
		if (optToken.isPresent()) {
			Token token = optToken.get();
			long date = token.getDate();
			long now = System.currentTimeMillis();
			if (now>date+24*60*60*1000)
				throw new ResponseStatusException(HttpStatus.GONE, "Token caducado \uD83D\uDCC6");
			String email = token.getEmail();
			User user = userRepository.findByEmail(email);
			if (user!=null) {
				user.setConfirmationDate(now);
				userRepository.save(user);
			} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado \uD83D\uDCBF");
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Token " + tokenId + " no encontrado");
	}

	/**
	 * Insert login.
	 *
	 * @param user   the user
	 * @param ip     the ip
	 * @param cookie the cookie
	 */
	public void insertLogin(User user, String ip, Cookie cookie) {
		Login login = new Login();
		login.setEmail(user.getEmail());
		login.setDate(System.currentTimeMillis());
		login.setIp(ip);
		login.setCookieValue(cookie.getValue());
		loginDAO.save(login);
	}

	/**
	 * Find user user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	public User findUser(String userId) {
		return this.connectedUsers.get(userId);
	}

	/**
	 * Find user by email boolean.
	 *
	 * @param email the email
	 * @return the boolean
	 */
	public boolean findUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null)
			return false;
		return true;
    }
}
