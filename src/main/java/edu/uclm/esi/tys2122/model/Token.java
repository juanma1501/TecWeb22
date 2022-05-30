package edu.uclm.esi.tys2122.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Token.
 */
@Entity
public class Token {
	@Id
	@Column(length = 36)
	private String id;
	private String email;
	private long date;

	/**
	 * Instantiates a new Token.
	 */
	public Token() {
	}

	/**
	 * Instantiates a new Token.
	 *
	 * @param email the email
	 */
	public Token(String email) {
		this.id = UUID.randomUUID().toString();
		this.email = email;
		this.date = System.currentTimeMillis();		
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
	 * Gets email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets date.
	 *
	 * @return the date
	 */
	public long getDate() {
		return date;
	}

	/**
	 * Sets date.
	 *
	 * @param date the date
	 */
	public void setDate(long date) {
		this.date = date;
	}
}
