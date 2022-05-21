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
    public int[] getAllSquare() {
        StonePaperScissorBoard board = (StonePaperScissorBoard) this.getBoard();
        return board.getArray();
    }


    public void setSquare(Integer x, int value) {
        StonePaperScissorBoard board = (StonePaperScissorBoard) this.getBoard();
        board.getArray()[x]=value;
    }

    @Override
    public void move(String userId, JSONObject jsoMovimiento) throws Exception {
        //match.move(user.getId(), jso (MOVE, matchId));
        boolean finish = false;
        System.out.println(jsoMovimiento);

        int movement = jsoMovimiento.getInt("move");
        System.out.println(movement);

        System.out.println(userId);

        User user = null;

        for (int i = 0; i < this.players.size();i++){
            if(this.players.get(i).getId() == userId){
                user = this.players.get(i);
            }
        }

        this.setPlayerWithTurn(user);

        if(this.filled())
            throw new Exception("La partida ya terminó");
        System.out.println("Jugador con turno: " + this.playerWithTurn.getName() +" con ID: "+ this.playerWithTurn.getId());


        if(!userId.equals(this.playerWithTurn.getId()))
            throw new Exception("Ins`t your turn");

        User user1 = this.players.get(0);
        User user2 = this.players.get(1);

        if (userId == user1.getId()){
            this.setSquare(0,movement);
        }else{
            this.setSquare(1,movement);
            finish = true;
        }

        if (finish){
            if (this.getAllSquare()[0] == this.getAllSquare()[1]){
                System.out.println("Empate");
            }else if((this.getAllSquare()[0] == 0 && this.getAllSquare()[1] == 2) || (this.getAllSquare()[0] == 1 && this.getAllSquare()[1] == 0) || (this.getAllSquare()[0] == 2 && this.getAllSquare()[1] == 1)){
                System.out.println(user1.getName() + " ha ganado la partida.");
            }else{
                System.out.println(user2.getName() + " ha ganado la partida.");
            }
        }

        for(int i=0 ; i< this.getAllSquare().length; i++){
            System.out.println(this.getAllSquare()[i]);
        }

    }

    private boolean filled() {
        StonePaperScissorBoard board = (StonePaperScissorBoard) this.getBoard();
        int[] squares = board.getArray();
        for (int i=0; i<squares.length; i++)
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
