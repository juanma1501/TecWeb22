package edu.uclm.esi.tys2122.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import edu.uclm.esi.tys2122.dao.MatchRepository;
import edu.uclm.esi.tys2122.dao.UserRepository;
import edu.uclm.esi.tys2122.model.Match;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import edu.uclm.esi.tys2122.model.Game;
import edu.uclm.esi.tys2122.model.User;
import edu.uclm.esi.tys2122.websockets.WrapperSession;
import org.springframework.web.socket.WebSocketSession;

/**
 * The type Manager.
 */
@Component
public class Manager {
	
	private Vector<Game> games;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MatchRepository matchRepository;
	
	private JSONObject configuration;

	private ConcurrentHashMap<String, HttpSession> httpSessions;

	private ConcurrentHashMap<String, WrapperSession> ajedrezSessionsPorHttp;

	private ConcurrentHashMap<String, WrapperSession> partidasPorWebSockets;

	private ConcurrentHashMap<String, Match> matches;

	private Vector<WebSocketSession> chatSessions;

	private Manager() {
		this.games = new Vector<>();
		this.httpSessions = new ConcurrentHashMap<>();
		this.chatSessions = new Vector<>();
		this.ajedrezSessionsPorHttp = new ConcurrentHashMap<>();
		this.partidasPorWebSockets = new ConcurrentHashMap<>();
		this.matches = new ConcurrentHashMap<>();
		try {
			loadParameters();
		} catch (Exception e) {
			System.err.println("Error al leer el fichero parametros.txt: " + e.getMessage());
			System.exit(-1);
		}
	}

	/**
	 * Add chat session.
	 *
	 * @param wsSession the ws session
	 */
	public void addChatSession(WebSocketSession wsSession) {
		this.chatSessions.add(wsSession);
	}

	/**
	 * Remove chat session.
	 *
	 * @param wssession the wssession
	 */
	public void removeChatSession(WebSocketSession wssession) {
		Vector<WebSocketSession> chatSessions = this.getChatSessions();
		for(WebSocketSession ws : chatSessions) {
			if(ws.getId() == wssession.getId()) {
				chatSessions.remove(ws);
				break;
			}
		}

	}

	/**
	 * Cerrar conexion.
	 *
	 * @param wssession the wssession
	 */
	public void cerrarConexion(WebSocketSession wssession) {
		this.partidasPorWebSockets.remove(wssession);
	}


	/**
	 * Sets chat sessions.
	 *
	 * @param chatSessions the chat sessions
	 */
	public void setChatSessions(Vector<WebSocketSession> chatSessions) {
		this.chatSessions = chatSessions;
	}

	/**
	 * Gets chat sessions.
	 *
	 * @return the chat sessions
	 */
	public Vector<WebSocketSession> getChatSessions() {
		return chatSessions;
	}

	/**
	 * Put.
	 *
	 * @param id    the id
	 * @param match the match
	 */
	public void put(String id, Match match) {
		this.matches.put(id, match);
	}

	/**
	 * Find match match.
	 *
	 * @param id the id
	 * @return the match
	 */
	public Match findMatch(String id){
		return this.matches.get(id);
	}

	/**
	 * Gets user repository.
	 *
	 * @return the user repository
	 */
	public UserRepository getUserRepository() {
		return userRepository;
	}



	private static class ManagerHolder {
		/**
		 * The Singleton.
		 */
		static Manager singleton=new Manager();
	}

	/**
	 * Get manager.
	 *
	 * @return the manager
	 */
	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}

	/**
	 * Gets configuration.
	 *
	 * @return the configuration
	 */
	public JSONObject getConfiguration() {
		return configuration;
	}
	
	private void loadParameters() throws IOException {
		this.configuration = read("./parametros.txt");
	}
	
	private JSONObject read(String fileName) throws IOException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 try (InputStream fis = classLoader.getResourceAsStream(fileName)) {
			byte[] b = new byte[fis.available()];
			fis.read(b);
			String s = new String(b);
			return new JSONObject(s);
		 }
	}

	/**
	 * Read file as json array json array.
	 *
	 * @param fileName the file name
	 * @return the json array
	 * @throws IOException the io exception
	 */
	public JSONArray readFileAsJSONArray(String fileName) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		 try (InputStream fis = classLoader.getResourceAsStream(fileName)) {
			byte[] b = new byte[fis.available()];
			fis.read(b);
			String s = new String(b);
			return new JSONArray(s);
		 }
	}

	/**
	 * Clear games.
	 */
	public void clearGames() {
		this.games.clear();
	}

	/**
	 * Add.
	 *
	 * @param game the game
	 */
	public void add(Game game) {
		this.games.add(game);
	}

	/**
	 * Gets games.
	 *
	 * @return the games
	 */
	public Vector<Game> getGames() {
		return games;
	}

	/**
	 * Find game game.
	 *
	 * @param gameName the game name
	 * @return the game
	 */
	public Game findGame(String gameName) {
		for (Game game : this.games)
			if (game.getName().equals(gameName))
				return game;
		return null;
	}

	/**
	 * Add.
	 *
	 * @param wrapperSession the wrapper session
	 * @param httpSessionId  the http session id
	 */
	public void add(WrapperSession wrapperSession, String httpSessionId) {
		HttpSession httpSession = this.httpSessions.get(httpSessionId);
		User user = (User) httpSession.getAttribute("user");
		user.setSession(wrapperSession);
		wrapperSession.setHttpSession(httpSession);
		this.ajedrezSessionsPorHttp.put(httpSessionId, wrapperSession);
		this.partidasPorWebSockets.put(wrapperSession.getWsSession().getId(), wrapperSession);
	}

	/**
	 * Add.
	 *
	 * @param session the session
	 */
	public void add(HttpSession session) {
		this.httpSessions.put(session.getId(), session);
	}

	/**
	 * Gets match repository.
	 *
	 * @return the match repository
	 */
	public MatchRepository getMatchRepository() {
		return this.matchRepository;
	}


}
