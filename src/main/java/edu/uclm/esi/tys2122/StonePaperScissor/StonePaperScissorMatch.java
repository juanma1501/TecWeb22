package edu.uclm.esi.tys2122.StonePaperScissor;

import edu.uclm.esi.tys2122.model.Board;
import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.model.User;
import edu.uclm.esi.tys2122.tictactoe.TictactoeBoard;
import org.json.JSONObject;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.security.SecureRandom;

public class StonePaperScissorMatch extends Match {
    private User winner, looser;
    private boolean draw;
    private String lastUser;
    private String message;

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

    public String getMessage(){
        return this.message;
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
        boolean finish = false;
        System.out.println(jsoMovimiento);
        int movement = jsoMovimiento.getInt("move");
        System.out.println(movement);
        System.out.println(userId);
        User user1 = this.players.get(0);
        User user2 = this.players.get(1);


        if(!userId.equals(this.playerWithTurn.getId())){
            this.message = "Please, is the turn of "+ this.playerWithTurn.getName();
            this.notifyMessage(this.getId(), this.message);
            throw new Exception("Ins`t your turn");
        }

        if (userId == user1.getId()){
            this.setSquare(0,movement);
            System.out.println("Acaba de tirar: " + user1.getName());
            this.setPlayerWithTurn(user2);
        }else{
            this.setSquare(1,movement);
            System.out.println("Acaba de tirar: " + user2.getName());
            this.setPlayerWithTurn(user1);
        }

        System.out.println("Jugador con turno: " + this.playerWithTurn.getName() +" con ID: "+ this.playerWithTurn.getId());
        printTablero();

        System.out.println("¿Relleno?" + this.filled());

        if(this.filled()){
            checkWinner(user1, user2);
            //throw new Exception("La partida ya terminó");
        }
    }

    private void getLooser(String id){
        for (int i = 0; i< this.players.size();i++){
            if (!this.players.get(i).getId().equals(id)){
                this.looser = this.players.get(i);
            }
        }
    }

    private void printTablero(){
        for(int i=0 ; i< this.getAllSquare().length; i++){
            System.out.println(this.getAllSquare()[i]);
        }
    }

    private void checkWinner( User user1, User user2){
            if (this.getAllSquare()[0] == this.getAllSquare()[1]){
                this.draw = true;
                System.out.println("Empate");
            }else if((this.getAllSquare()[0] == 1 && this.getAllSquare()[1] == 3) || (this.getAllSquare()[0] == 2 && this.getAllSquare()[1] == 1) || (this.getAllSquare()[0] == 3 && this.getAllSquare()[1] == 2)){
                System.out.println(user1.getName() + " ha ganado la partida.");
                this.winner = user1;
                this.draw = false;
                getLooser(this.winner.getId());
            }else{
                System.out.println(user2.getName() + " ha ganado la partida.");
                this.winner = user2;
                this.draw = false;
                getLooser(this.winner.getId());
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
    public boolean getFilled() {
        return this.filled();
    }

    public User getWinner() {
        return winner;
    }

    public User getLooserUser() {
        return this.looser;
    }

    public boolean isDraw() {
        return draw;
    }

    public boolean getDraw(){
        return this.draw;
    }
}
