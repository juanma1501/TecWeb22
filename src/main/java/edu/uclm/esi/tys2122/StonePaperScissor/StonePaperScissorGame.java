package edu.uclm.esi.tys2122.StonePaperScissor;

import edu.uclm.esi.tys2122.model.Game;
import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.tictactoe.TictactoeMatch;

public class StonePaperScissorGame extends Game {

    public StonePaperScissorGame() {
        super();
    }

    @Override
    public Match newMatch() {
        return new StonePaperScissorMatch();
    }
}
