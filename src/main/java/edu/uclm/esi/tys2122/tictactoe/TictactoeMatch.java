package edu.uclm.esi.tys2122.tictactoe;

import java.security.SecureRandom;

import edu.uclm.esi.tys2122.dao.MatchRepository;
import edu.uclm.esi.tys2122.http.Manager;
import org.json.JSONObject;

import edu.uclm.esi.tys2122.model.Board;
import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * The type Tictactoe match.
 */
public class TictactoeMatch extends Match {
	
	private User winner;

	/**
	 * Sets winner.
	 *
	 * @param winner the winner
	 */
	public void setWinner(User winner) {
		this.winner = winner;
	}

	/**
	 * Sets looser.
	 *
	 * @param looser the looser
	 */
	public void setLooser(User looser) {
		this.looser = looser;
	}

	private User looser;
	private boolean draw;
	private String lastUser;
	
	@Override
	protected Board newBoard() {
		return new TictactoeBoard();
	}

	@Override
	protected void checkReady() {
		this.ready = this.players.size()==2;

		if (this.ready)
			this.playerWithTurn = new SecureRandom().nextBoolean() ? this.players.get(0) : this.players.get(1);
	}

	/**
	 * Gets square.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the square
	 */
	public int getSquare(Integer x, Integer y) {
		TictactoeBoard board = (TictactoeBoard) this.getBoard();
		return board.getSquares()[x][y];
	}

	/**
	 * Sets square.
	 *
	 * @param x     the x
	 * @param y     the y
	 * @param value the value
	 */
	public void setSquare(Integer x, Integer y, int value) {
		TictactoeBoard board = (TictactoeBoard) this.getBoard();
		board.getSquares()[x][y]=value;
	}

	@Override
	public void move(String userId, JSONObject jsoMovimiento) throws Exception {

		Integer x;
		Integer y;

		if (this.filled() || this.winner != null || this.isDraw())
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Esta partida ya terminó ⏹");

		if(this.playerWithTurn == null){
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Espera a que se una un nuevo jugador! ⛔");
		}

		System.out.println("Los IDs son:");
		System.out.println(this.getPlayerWithTurn().getId() + " " + this.getPlayerWithTurn().getName());
		System.out.println(userId);
		
		if (!this.getPlayerWithTurn().getId().equals(userId))
			throw new ResponseStatusException(HttpStatus.CONFLICT, "No es tu turno! ⛔");

		try {
			 x = jsoMovimiento.getInt("x");
			 y = jsoMovimiento.getInt("y");
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Escribe una casilla válida para ocupar!");
		}

		try {
			if (this.getSquare(x, y) != 0)
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Esta casila está ocupada ⛔");
		}catch (ArrayIndexOutOfBoundsException e){
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Esa casilla no existe! Elige valores de 0️⃣ a 2️⃣");
		}
		
		int value = this.getPlayerWithTurn()==this.getPlayers().get(0) ? 1 : 2;
		this.setSquare(x, y, value);
		
		checkWinner();
		
		if (this.filled() && this.winner==null)
			this.draw = true;
		else {
			this.playerWithTurn = this.getPlayerWithTurn()==this.getPlayers().get(0) ?
				this.getPlayers().get(1) : this.getPlayers().get(0);
		}
	}

	private boolean filled() {
		TictactoeBoard board = (TictactoeBoard) this.getBoard();
		int[][] squares = board.getSquares();
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
				if (squares[i][j]==0)
					return false;
		return true;
	}

	private void checkWinner() {
		TictactoeBoard board = (TictactoeBoard) this.getBoard();
		int[][] squares = board.getSquares();
		
		if (squares[0][0]!=0 && squares[0][0]==squares[0][1] && squares[0][1]==squares[0][2] ||
				squares[1][0]!=0 && squares[1][0]==squares[1][1] && squares[1][1]==squares[1][2] ||
				squares[2][0]!=0 && squares[2][0]==squares[2][1] && squares[2][1]==squares[2][2]) {
			this.winner = this.getPlayerWithTurn();
		} else if (squares[0][0]!=0 && squares[0][0]==squares[1][0] && squares[1][0]==squares[2][0] ||
				squares[0][1]!=0 && squares[0][1]==squares[1][1] && squares[1][1]==squares[2][1] ||
				squares[0][2]!=0 && squares[0][2]==squares[1][2] && squares[2][1]==squares[2][2]) {
			this.winner = this.getPlayerWithTurn();
		} else if (squares[0][0]!=0 && squares[0][0]==squares[1][1] && squares[1][1]==squares[2][2] ||
				squares[0][2]!=0 && squares[0][2]==squares[1][1] && squares[1][1]==squares[2][0]) {
			this.winner = this.getPlayerWithTurn();
		}
		if (this.winner!=null) {
			this.looser = this.winner==this.players.get(0) ? this.players.get(1) : this.players.get(0);
			Manager.get().getMatchRepository().saveMatch(this.getId(), this.getGame(), this.getLooser(), this.getWinner(), this.isDraw());
		}



	}

	@Override
	public void cerrarCuandoSeRinda(User user) {

		try {
			this.setLooser(user);
			for (User u_ : this.players)
				if (!u_.equals(user))
					this.setWinner(u_);

			Manager.get().getMatchRepository().saveMatch(this.getId(), this.getGame(), this.getLooser(), this.getWinner(), this.isDraw());
			notifyNewState(this.getWinner().getId());
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.CONFLICT, "En serio te quieres rendir dos veces? ⛔");
		}
	}

	public User getWinner() {
		return winner;
	}
	
	public User getLooser() {
		return looser;
	}

	/**
	 * Is draw boolean.
	 *
	 * @return the boolean
	 */
	public boolean isDraw() {
		return draw;
	}
}
