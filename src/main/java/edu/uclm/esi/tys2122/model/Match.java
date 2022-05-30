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
import edu.uclm.esi.tys2122.StonePaperScissor.StonePaperScissorMatch;
import edu.uclm.esi.tys2122.dao.UserRepository;
import edu.uclm.esi.tys2122.http.Manager;
import edu.uclm.esi.tys2122.tictactoe.TictactoeMatch;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * The type Match.
 */
@Entity
@Table(name = "partida")
public abstract class Match {
    @Id
    @Column(length = 36)
    private String id;

    @Transient
    private Board board;

    /**
     * The Players.
     */
    @Transient
    protected Vector<User> players;

    /**
     * The Player with turn.
     */
    @Transient
    protected User playerWithTurn;

    /**
     * The Ready.
     */
    @Transient
    protected boolean ready;

    /**
     * The User repository.
     */
    @Transient
    @Autowired
    protected UserRepository userRepository;

    /**
     * Instantiates a new Match.
     */
    public Match() {
        this.id = UUID.randomUUID().toString();
        this.players = new Vector<>();
        this.board = newBoard();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets board.
     *
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Gets winner.
     *
     * @return the winner
     */
    public abstract User getWinner();

    /**
     * Gets looser.
     *
     * @return the looser
     */
    public abstract User getLooser();


    /**
     * Sets board.
     *
     * @param board the board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Add player.
     *
     * @param user the user
     */
// TODO : no se puede añadir dos veces el mismo jugador
    public void addPlayer(User user) {
        this.players.add(user);
        checkReady();
    }

    /**
     * Is ready boolean.
     *
     * @return the boolean
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Gets player with turn.
     *
     * @return the player with turn
     */
    public User getPlayerWithTurn() {
        return playerWithTurn;
    }

    /**
     * Sets player with turn.
     *
     * @param user the user
     */
    public void setPlayerWithTurn (User user) {
        this.playerWithTurn = user;
    }

    /**
     * Gets players.
     *
     * @return the players
     */
    @Transient
    public Vector<User> getPlayers() {
        return players;
    }

    /**
     * Check ready.
     */
    protected abstract void checkReady();

    /**
     * New board board.
     *
     * @return the board
     */
    protected abstract Board newBoard();

    /**
     * Move.
     *
     * @param userId the user id
     * @param jso    the jso
     * @throws Exception the exception
     */
    public abstract void move(String userId, JSONObject jso) throws Exception;

    /**
     * Notify new state.
     *
     * @param userId the user id
     */
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

    /**
     * Notify new state second game.
     *
     * @param userId the user id
     */
    public void notifyNewStateSecondGame(String userId) {
        JSONObject jso = new JSONObject();
        jso.put("type", "BOARD");
        jso.put("id", this.id);
        jso.put("playerWithTurn", this.playerWithTurn.getName());

        StonePaperScissorMatch match = (StonePaperScissorMatch) Manager.get().findMatch(this.id);

        if(match.getFilled()){

            if(match.getWinner() != null){
                String winner = match.getWinner().getName();
                String looser = match.getLooser().getName();
                boolean draw = match.getDraw();

                jso.put("winner", winner);
                jso.put("looser", looser);
                jso.put("draw", draw);
            }else{
                boolean draw = match.getDraw();
                jso.put("draw", draw);
            }


            Gson gson = new Gson();
            JSONArray jsonArray = new JSONArray(gson.toJson(this.board.getArray()));
            jso.put("board", jsonArray);
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

    /**
     * Notify message.
     *
     * @param userId  the user id
     * @param message the message
     */
    public void notifyMessage(String userId, String message) {
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
        jso.put("message", message);

        for (User player : this.players) {
            try {
                player.sendMessage(jso);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * Notify preparada.
     */
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

    /**
     * Gets game.
     *
     * @return the game
     */
    public String getGame() {
        return this.getClass().getSimpleName();
    }

    /**
     * Cerrar cuando se rinda.
     *
     * @param user the user
     */
    public abstract void cerrarCuandoSeRinda(User user);

}
