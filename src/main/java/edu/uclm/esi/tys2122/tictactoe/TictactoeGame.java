package edu.uclm.esi.tys2122.tictactoe;

import edu.uclm.esi.tys2122.model.Game;
import edu.uclm.esi.tys2122.model.Match;

/**
 * The type Tictactoe game.
 */
public class TictactoeGame extends Game {

	/**
	 * Instantiates a new Tictactoe game.
	 */
	public TictactoeGame() {
		super();
	}

	@Override
	public Match newMatch() {
		return new TictactoeMatch();
	}
}
