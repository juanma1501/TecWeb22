package edu.uclm.esi.tys2122.StonePaperScissor;

import edu.uclm.esi.tys2122.model.Board;
import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.model.User;
import edu.uclm.esi.tys2122.tictactoe.TictactoeBoard;
import org.json.JSONObject;

import java.security.SecureRandom;

public class StonePaperScissorMatch extends Match {
    private User winner, looser;
    private boolean draw;
    private String lastUser;

    @Override
    protected Board newBoard() {
        return new StonePaperScissorBoard();
    }

    @Override
    protected void checkReady() {
        this.ready = this.players.size()==2;

        if (this.ready)
            this.playerWithTurn = new SecureRandom().nextBoolean() ? this.players.get(0) : this.players.get(1);
    }

    public int getSquare(Integer x) {
        StonePaperScissorBoard board = (StonePaperScissorBoard) this.getBoard();
        return board.getArray()[x];
    }

    public void setSquare(Integer x, int value) {
        StonePaperScissorBoard board = (StonePaperScissorBoard) this.getBoard();
        board.getArray()[x]=value;
    }

    @Override
    public void move(String userId, JSONObject jsoMovimiento) throws Exception {

    }

    private boolean filled() {
        StonePaperScissorBoard board = (StonePaperScissorBoard) this.getBoard();
        int[] squares = board.getArray();
        for (int i=0; i<3; i++)
                if (squares[i]==0)
                    return false;
        return true;
    }

    private void checkWinner() {
        StonePaperScissorBoard board = (StonePaperScissorBoard) this.getBoard();
        int[] squares = board.getArray();

        if (true){

        }
        if (this.winner!=null) {
            this.looser = this.winner==this.players.get(0) ? this.players.get(1) : this.players.get(0);
            System.out.println(this.looser.getName());
        }



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
