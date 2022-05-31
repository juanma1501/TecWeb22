package edu.uclm.esi.tys2122.StonePaperScissor;

import edu.uclm.esi.tys2122.model.Game;
import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.tictactoe.TictactoeMatch;

/**
 * The type Stone paper scissor game.
 */
public class StonePaperScissorGame extends Game {

    /**
     * Instantiates a new Stone paper scissor game.
     */
    public StonePaperScissorGame() {
        super();
    }

    @Override
    public Match newMatch() {
        return new StonePaperScissorMatch();
    }
}
