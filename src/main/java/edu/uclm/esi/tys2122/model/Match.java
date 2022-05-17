package edu.uclm.esi.tys2122.model;

import java.io.IOException;
import java.util.UUID;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.Gson;
import edu.uclm.esi.tys2122.http.Manager;
import edu.uclm.esi.tys2122.tictactoe.TictactoeMatch;
import org.json.JSONArray;
import org.json.JSONObject;


@Entity
@Table(name = "partida")
public abstract class Match {
    @Id
    @Column(length = 36)
    private String id;

    @Transient
    private Board board;

    @Transient
    protected Vector<User> players;

    @Transient
    protected User playerWithTurn;

    @Transient
    protected boolean ready;

    public Match() {
        this.id = UUID.randomUUID().toString();
        this.players = new Vector<>();
        this.board = newBoard();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    // TODO : no se puede añadir dos veces el mismo jugador
    public void addPlayer(User user) {
        this.players.add(user);
        checkReady();
    }

    public boolean isReady() {
        return ready;
    }

    public User getPlayerWithTurn() {
        return playerWithTurn;
    }

    @Transient
    public Vector<User> getPlayers() {
        return players;
    }

    protected abstract void checkReady();

    protected abstract Board newBoard();

    public abstract void move(String userId, JSONObject jso) throws Exception;

    public void notifyNewState(String userId) {
        JSONObject jso = new JSONObject();
        JSONObject movement = new JSONObject();
        jso.put("type", "BOARD");
        jso.put("id", this.id);
        //jso.put("board", this.board);
        Gson gson = new Gson();
        JSONArray jsonArray = new JSONArray(gson.toJson(this.board.getSquares()));
        movement.put("squares", jsonArray);
        jso.put("board", movement);
        jso.put("playerWithTurn", this.playerWithTurn.getName());

        TictactoeMatch match = (TictactoeMatch) Manager.get().findMatch(this.id);
        if(match.getWinner() != null) {
            jso.put("winner", match.getWinner().getName());
            jso.put("looser", match.getLooser().getName());
            jso.put("draw", match.isDraw());
        }


        for (User player : this.players) {
                try {
                    player.sendMessage(jso);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

    public void notifyPreparada() {
        JSONObject jso = new JSONObject();
        JSONObject user = new JSONObject(this.players.get(this.players.size() - 1).getUser());
        jso.put("type", "PREPARADA");
        jso.put("id", this.id);
        jso.put("player", user);
        jso.put("playerWithTurn", this.playerWithTurn.getName());
        //System.out.println();

        // jso.put("board", this.board.toJSON());

        for (User player : this.players) {
            try {
                player.sendMessage(jso);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
