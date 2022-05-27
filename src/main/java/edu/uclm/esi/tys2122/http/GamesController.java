package edu.uclm.esi.tys2122.http;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import edu.uclm.esi.tys2122.websockets.WrapperSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import edu.uclm.esi.tys2122.model.Game;
import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.model.User;
import edu.uclm.esi.tys2122.services.GamesService;
import edu.uclm.esi.tys2122.services.UserService;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@CrossOrigin
@RestController
@RequestMapping("games")
public class GamesController extends CookiesController {
	@Autowired
	private GamesService gamesService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getGames")
	public List<Game> getGames(HttpSession session) throws Exception {
		User user;
		if (session.getAttribute("user")!=null) {
			user = (User) session.getAttribute("user");
		} else {
			user = new User();
			user.setName("anonimo" + new SecureRandom().nextInt(1000));
			session.setAttribute("user", user);
		}
		Manager.get().add(session);
		return gamesService.getGames();
	}

	@GetMapping("/joinGame/{gameName}")
	public Match joinGame(HttpSession session, @PathVariable String gameName, @RequestParam(required = false) boolean cpu) throws Exception {
		User user;
		System.out.println(gameName);
		if(cpu) {

			user = User.fakeUser();
			User real = (User) session.getAttribute("user");
			user.setSession(real.getSession());

		}else if (session.getAttribute("user")!=null) {
			user = (User) session.getAttribute("user");
		} else {
			user = new User();
			user.setName("anonimo" + new SecureRandom().nextInt(1000));
			session.setAttribute("user", user);
		}

		Manager.get().add(session);
		
		Game game = Manager.get().findGame(gameName);
		System.out.println(Manager.get().getGames().size());
		System.out.println(game);
		if (game==null)
			throw new Exception("No se encuentra el juego " + gameName);
		
		Match match = getMatch(game);

		match.addPlayer(user);

		if (match.isReady()) {
			game.getPendingMatches().remove(match);
			game.getPlayingMatches().add(match);
			match.notifyPreparada();
		}

		gamesService.put(match);
		return match;
	}

	@PostMapping("/move")
	public Match move(HttpSession session, @RequestBody Map<String, Object> movement, @RequestParam(required = false) boolean cpu) throws Exception {
		User user;
		JSONObject jso = new JSONObject(movement);
		Match match = gamesService.getMatch(jso.getString("matchId"));

		if (cpu){
			user = match.getPlayers().get(1);
		}else{
			user = (User) session.getAttribute("user");
		}


		System.out.println("User: "+ user+" ;; "+ jso);
		System.out.println(match.getId());
		match.move(user.getId(), jso);
		match.notifyNewState(user.getId());
		return match;
	}

	@PostMapping("/move2")
	public Match move2(HttpSession session, @RequestBody Map<String, Object> movement) throws Exception {
		User user = (User) session.getAttribute("user");
		JSONObject jso = new JSONObject(movement);
		System.out.println("User: "+ user+" ;; "+ jso);
		Match match = gamesService.getMatch(jso.getString("matchId"));
		System.out.println(match.getId());
		match.move(user.getId(), jso);
		match.notifyNewStateSecondGame(user.getId());
		//if finish : notifytablero
		return match;
	}
	
	@GetMapping("/findMatch/{matchId}")
	public Match findMatch(@PathVariable String matchId) {
		return gamesService.getMatch(matchId);
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

	@PostMapping("/sendMessageChat")
	public void sendMessageChat(HttpSession session, @RequestBody Map<String, Object> messageInfo) {
		JSONObject jso = new JSONObject(messageInfo);
		String msg = jso.getString("msg");
		User user = (User) session.getAttribute("user");

		JSONObject jsoMsg = new JSONObject();
		jsoMsg.put("user", user.getName());
		jsoMsg.put("msg", msg);
		byte[] payload = jsoMsg.toString().getBytes();
		TextMessage message = new TextMessage(payload);

		for (WebSocketSession ws : Manager.get().getChatSessions()) {
			try {
				ws.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@GetMapping("/getStatistics")
	public int[] getStatistics(HttpSession session) {
		int[] statistics = {0, 0, 0, 0, 0};
		User user = null;
		user = (User) session.getAttribute("user");

		if (user != null) {
			Object[] array = (Object[]) Manager.get().getMatchRepository().getStatistics(user.getId())[0];
			boolean token = false;

			for (int i = 0; i < array.length; i++) {
				token = ((BigInteger) array[i]).intValue() == 0 ? token : true;
				statistics[i + 1] = ((BigInteger) array[i]).intValue();
			}
			statistics[0] = token ? 1 : 0;
		}

		return statistics;
	}

	@GetMapping("/rendirse/{matchId}")
	public void rendirse(HttpSession session, @PathVariable String matchId) throws Exception {
		User user = (User) session.getAttribute("user");
		Match partida = gamesService.getMatch(matchId);
		partida.cerrarCuandoSeRinda(user);
	}


}



