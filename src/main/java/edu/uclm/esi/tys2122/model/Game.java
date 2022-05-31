package edu.uclm.esi.tys2122.model;

import java.util.List;
import java.util.Vector;

/**
 * The type Game.
 */
public abstract class Game {
	private String name;
	
	private List<Match> pendingMatches;
	private List<Match> playingMatches;

	/**
	 * Instantiates a new Game.
	 */
	public Game() {
		this.pendingMatches = new Vector<>();
		this.playingMatches = new Vector<>();
	}

	/**
	 * Instantiates a new Game.
	 *
	 * @param name the name
	 */
	public Game(String name) {
		super();
		this.name = name;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets pending matches.
	 *
	 * @return the pending matches
	 */
	public List<Match> getPendingMatches() {
		return pendingMatches;
	}

	/**
	 * Gets playing matches.
	 *
	 * @return the playing matches
	 */
	public List<Match> getPlayingMatches() {
		return playingMatches;
	}

	/**
	 * New match match.
	 *
	 * @return the match
	 */
	public abstract Match newMatch();


}
