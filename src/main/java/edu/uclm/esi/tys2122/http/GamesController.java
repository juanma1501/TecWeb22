package edu.uclm.esi.tys2122.http;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uclm.esi.tys2122.model.Game;
import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.model.User;
import edu.uclm.esi.tys2122.services.GamesService;
import edu.uclm.esi.tys2122.services.UserService;

@RestController
@RequestMapping("games")
public class GamesController extends CookiesController {
	@Autowired
	private GamesService gamesService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getGames")
	public List<Game> getGames() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		return gamesService.getGames();
	}

	@GetMapping("/joinGame/{gameName}")
	public Match joinGame(HttpSession session, @PathVariable String gameName) throws Exception {
		Game game = Manager.get().findGame(gameName);
		if (game==null)
			throw new Exception("No se encuentra el juego " + gameName);
		
		Match match = getMatch(game);
		String userId = session.getAttribute("userId").toString();
		User user = this.userService.findUser(userId);
		match.addPlayer(user);
		gamesService.put(match);
		return match;
	}
	
	@PostMapping("/move")
	public Match move(HttpSession session, @RequestBody Map<String, Object> movement) throws Exception {
		String userId = session.getAttribute("userId").toString();
		JSONObject jso = new JSONObject(movement);
		Match match = gamesService.getMatch(jso.getString("matchId"));
		match.move(userId, jso);
		return match;
	}

	private Match getMatch(Game game) {
		Match match;
		if (game.getPendingMatches().isEmpty()) {
			match = game.newMatch();
			game.getPendingMatches().add(match);
		} else {
			match = game.getPendingMatches().get(0);
		}
		return match;
	}
}
