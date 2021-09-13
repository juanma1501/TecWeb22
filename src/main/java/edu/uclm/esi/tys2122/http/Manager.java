package edu.uclm.esi.tys2122.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import edu.uclm.esi.tys2122.model.User;
import edu.uclm.esi.tys2122.dao.ChessMatchRepository;
import edu.uclm.esi.tys2122.dao.MovementRepository;
import edu.uclm.esi.tys2122.dao.TokenRepository;
import edu.uclm.esi.tys2122.dao.UserRepository;

@Component
public class Manager {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenRepository tokensRepository;
	@Autowired
	private ChessMatchRepository chessMatchRepo;
	@Autowired
	private MovementRepository movementRepo;
	
	private ConcurrentHashMap<String, User> users;
	private JSONObject configuration;

	private Manager() {
		this.users = new ConcurrentHashMap<>();
		try {
			loadParameters();
		} catch (Exception e) {
			System.err.println("Error al leer el fichero parametros.txt: " + e.getMessage());
			System.exit(-1);
		}
	}
	
	private static class ManagerHolder {
		static Manager singleton=new Manager();
	}
	
	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}

	public JSONObject getConfiguration() {
		return configuration;
	}
	
	private void loadParameters() throws FileNotFoundException, IOException {
		this.configuration = read("./parametros.txt");
	}
	
	private JSONObject read(String fileName) throws FileNotFoundException, IOException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 try (InputStream fis = classLoader.getResourceAsStream(fileName)) {
			byte[] b = new byte[fis.available()];
			fis.read(b);
			String s = new String(b);
			return new JSONObject(s);
		 }
	}
	
	public void add(User user) {
		this.users.put(user.getName(), user);
	}
	
	public User findUser(String userName) {
		return this.users.get(userName);
	}
	
	public User removeUser(String userName) {
		return this.users.remove(userName);
	}
	
	public UserRepository getUsersRepository() {
		return this.userRepository;
	}
	
	public TokenRepository getTokensRepository() {
		return tokensRepository;
	}
	
	public ChessMatchRepository getChessMatchRepo() {
		return chessMatchRepo;
	}
	
	public MovementRepository getMovementRepo() {
		return movementRepo;
	}
}
