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

	public void addChatSession(WebSocketSession wsSession) {
		this.chatSessions.add(wsSession);
	}

	public void removeChatSession(WebSocketSession wssession) {
		Vector<WebSocketSession> chatSessions = this.getChatSessions();
		for(WebSocketSession ws : chatSessions) {
			if(ws.getId() == wssession.getId()) {
				chatSessions.remove(ws);
				break;
			}
		}

	}

	public void cerrarConexion(WebSocketSession wssession) {
		this.partidasPorWebSockets.remove(wssession);
	}


	public void setChatSessions(Vector<WebSocketSession> chatSessions) {
		this.chatSessions = chatSessions;
	}

	public Vector<WebSocketSession> getChatSessions() {
		return chatSessions;
	}

	public void put(String id, Match match) {
		this.matches.put(id, match);
	}

	public Match findMatch(String id){
		return this.matches.get(id);
	}

	public UserRepository getUserRepository() {
		return userRepository;
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
	
	public JSONArray readFileAsJSONArray(String fileName) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		 try (InputStream fis = classLoader.getResourceAsStream(fileName)) {
			byte[] b = new byte[fis.available()];
			fis.read(b);
			String s = new String(b);
			return new JSONArray(s);
		 }
	}

	public void clearGames() {
		this.games.clear();
	}

	public void add(Game game) {
		this.games.add(game);
	}
	
	public Vector<Game> getGames() {
		return games;
	}

	public Game findGame(String gameName) {
		for (Game game : this.games)
			if (game.getName().equals(gameName))
				return game;
		return null;
	}

	public void add(WrapperSession wrapperSession, String httpSessionId) {
		HttpSession httpSession = this.httpSessions.get(httpSessionId);
		User user = (User) httpSession.getAttribute("user");
		user.setSession(wrapperSession);
		wrapperSession.setHttpSession(httpSession);
		this.ajedrezSessionsPorHttp.put(httpSessionId, wrapperSession);
		this.partidasPorWebSockets.put(wrapperSession.getWsSession().getId(), wrapperSession);
	}

	public void add(HttpSession session) {
		this.httpSessions.put(session.getId(), session);
	}

	public MatchRepository getMatchRepository() {
		return this.matchRepository;
	}


}
