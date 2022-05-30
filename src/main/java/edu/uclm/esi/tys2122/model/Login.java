package edu.uclm.esi.tys2122.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Login.
 */
@Entity
public class Login {
	@Id
	@Column(length = 36)
	private String id;
	private String email;
	private String cookieValue;
	private String ip;
	private long date;

	/**
	 * Instantiates a new Login.
	 */
	public Login() {
		this.id = UUID.randomUUID().toString();
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
	 * Gets cookie value.
	 *
	 * @return the cookie value
	 */
	public String getCookieValue() {
		return cookieValue;
	}

	/**
	 * Sets cookie value.
	 *
	 * @param cookieValue the cookie value
	 */
	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}

	/**
	 * Gets ip.
	 *
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Sets ip.
	 *
	 * @param ip the ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
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
