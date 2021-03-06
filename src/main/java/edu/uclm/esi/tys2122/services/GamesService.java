package edu.uclm.esi.tys2122.services;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import edu.uclm.esi.tys2122.http.Manager;
import edu.uclm.esi.tys2122.model.Game;
import edu.uclm.esi.tys2122.model.Match;

/**
 * The type Games service.
 */
@Service
public class GamesService {
	
	private ConcurrentHashMap<String, Match> matches;

	/**
	 * Instantiates a new Games service.
	 *
	 * @throws Exception the exception
	 */
	public GamesService() throws Exception {
		this.matches = new ConcurrentHashMap<>();
		JSONArray jsa = Manager.get().readFileAsJSONArray("games.txt");
		JSONObject jso;
		String name, clazz;
		Game game;
		Manager.get().clearGames();
		for (int i=0; i<jsa.length(); i++) {
			jso = jsa.getJSONObject(i);
			name = jso.getString("name");
			clazz = jso.getString("clazz");
			game = (Game) Class.forName(clazz).newInstance();
			game.setName(name);
			Manager.get().add(game);
		}
	}

	/**
	 * New match match.
	 *
	 * @param clazz the clazz
	 * @return the match
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public Match newMatch(Class<? extends Match> clazz) throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

	/**
	 * Gets games.
	 *
	 * @return the games
	 * @throws IOException            the io exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public List<Game> getGames() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return Manager.get().getGames();
	}

	/**
	 * Put.
	 *
	 * @param match the match
	 */
	public void put(Match match) {
		this.matches.put(match.getId(), match);
		Manager.get().put(match.getId(), match);
	}

	/**
	 * Gets match.
	 *
	 * @param matchId the match id
	 * @return the match
	 */
	public Match getMatch(String matchId) {
		return this.matches.get(matchId);
	}

}
