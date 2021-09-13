package edu.uclm.esi.tys2122.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import edu.uclm.esi.tys2122.http.Manager;

@Entity
public class ChessMatch {
	@Id
	@Column(length = 36)
	private String id;
	@Column(length=20)
	private String white, black;
	private Integer whiteElo, blackElo;
	private String result;
	
	public ChessMatch() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWhite() {
		return white;
	}

	public void setWhite(String white) {
		int start = white.indexOf("\"");
		int end = white.indexOf("\"", start+1);
		this.white = white.substring(start+1, end);
	}

	public String getBlack() {
		return black;
	}

	public void setBlack(String black) {
		int start = black.indexOf("\"");
		int end = black.indexOf("\"", start+1);
		this.black = black.substring(start+1, end);
	}

	public Integer getWhiteElo() {
		return whiteElo;
	}

	public void setWhiteElo(String whiteElo) {
		int start = whiteElo.indexOf("\"");
		int end = whiteElo.indexOf("\"", start+1);
		this.whiteElo = Integer.parseInt(whiteElo.substring(start+1, end));
	}

	public void setWhiteElo(Integer whiteElo) {
		this.whiteElo = whiteElo;
	}

	public Integer getBlackElo() {
		return blackElo;
	}
	
	public void setBlackElo(String blackElo) {
		int start = blackElo.indexOf("\"");
		int end = blackElo.indexOf("\"", start+1);
		this.blackElo = Integer.parseInt(blackElo.substring(start+1, end));
	}

	public void setBlackElo(Integer blackElo) {
		this.blackElo = blackElo;
	}

	public void setMovements(String linea) {
		String movimientos = linea.substring(0, linea.lastIndexOf('.'));
		String last = linea.substring(movimientos.length()+1).trim();
		String[] tokens = movimientos.split(" ");
		int i=0, cont = 1;
		while (i<tokens.length-1) {
			Movement movement = new Movement();
			String index = tokens[i++];
			movement.setPos(Integer.parseInt(index.substring(0, index.indexOf('.'))));
			movement.setWhite(tokens[i++]);
			movement.setBlack(tokens[i++]);
			movement.setChessMatch(this);
			Manager.get().getMovementRepo().save(movement);
			cont++;
		}
		Movement movement = new Movement();
		movement.setPos(cont);
		tokens = last.split(" ");
		movement.setWhite(tokens[0]);
		int start = last.indexOf('{')+1;
		int end = last.indexOf('}');
		movement.setComment(last.substring(start, end));
		Manager.get().getMovementRepo().save(movement);
	}
		
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		int start = result.indexOf("\"");
		int end = result.indexOf("\"", start+1);
		this.result = result.substring(start+1, end);
	}
}
