package edu.uclm.esi.tys2122.tictactoe;

import java.security.SecureRandom;

import edu.uclm.esi.tys2122.dao.MatchRepository;
import edu.uclm.esi.tys2122.http.Manager;
import org.json.JSONObject;

import edu.uclm.esi.tys2122.model.Board;
import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.model.User;

public class TictactoeMatch extends Match {
	
	private User winner;

	public void setWinner(User winner) {
		this.winner = winner;
	}

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

	public int getSquare(Integer x, Integer y) {
		TictactoeBoard board = (TictactoeBoard) this.getBoard();
		return board.getSquares()[x][y];
	}

	public void setSquare(Integer x, Integer y, int value) {
		TictactoeBoard board = (TictactoeBoard) this.getBoard();
		board.getSquares()[x][y]=value;
	}

	@Override
	public void move(String userId, JSONObject jsoMovimiento) throws Exception {
		if (this.filled() || this.winner != null || this.isDraw())
			throw new Exception("La partida ya terminó");

		System.out.println("Los IDs son:");
		System.out.println(this.getPlayerWithTurn().getId() + " " + this.getPlayerWithTurn().getName());
		System.out.println(userId);
		
		if (!this.getPlayerWithTurn().getId().equals(userId))
			throw new Exception("No es tu turno");
		
		Integer x = jsoMovimiento.getInt("x");
		Integer y = jsoMovimiento.getInt("y");
		
		if (this.getSquare(x, y)!=0)
			throw new Exception("Casilla ocupada");
		
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
		this.setLooser(user);
		for (User u_ : this.players)
			if(!u_.equals(user))
				this.setWinner(u_);

		Manager.get().getMatchRepository().saveMatch(this.getId(), this.getGame(), this.getLooser(), this.getWinner(), this.isDraw());
		notifyNewState(this.getWinner().getId());
	}

	public User getWinner() {
		return winner;
	}
	
	public User getLooser() {
		return looser;
	}
	
	public boolean isDraw() {
		return draw;
	}
}
