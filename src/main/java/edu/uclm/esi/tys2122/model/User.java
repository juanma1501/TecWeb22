package edu.uclm.esi.tys2122.model;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.uclm.esi.tys2122.websockets.WrapperSession;

/**
 * The type User.
 */
@Entity
@Table(indexes = {
	@Index(unique = true, columnList = "email"),
	@Index(unique = true, columnList = "name"),
})
public class User {
	@Id
	@Column(length = 36)
	private String id;
	@NotBlank 
	private String email;
	@NotBlank
	private String name;
	@NotBlank
	private String pwd;
	@Column(length = 36)
	private String cookie;
	private String picture;
	private Long confirmationDate;
	private String type;
	private String token;
	
	@Transient
	private WrapperSession session;

	/**
	 * Instantiates a new User.
	 */
	public User() {
		this.id = UUID.randomUUID().toString();
	}

	/**
	 * Instantiates a new User.
	 *
	 * @param id    the id
	 * @param name  the name
	 * @param email the email
	 */
//Google
	public User(@NotBlank String id, @NotBlank String name, @NotBlank String email) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.pwd = org.apache.commons.codec.digest.DigestUtils.sha512Hex(UUID.randomUUID().toString());
		this.type = "google";
	}


	/**
	 * Fake user user.
	 *
	 * @return the user
	 */
	public static User fakeUser() {
		User cpu = new User();
		cpu.name = "cpu";

		return cpu;
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
	@JsonIgnore
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
	 * @param userName the user name
	 */
	public void setName(String userName) {
		this.name = userName;
	}

	/**
	 * Gets pwd.
	 *
	 * @return the pwd
	 */
	@JsonIgnore
	public String getPwd() {
		return pwd;
	}

	/**
	 * Gets user.
	 *
	 * @return the user
	 */
	public String getUser() {
		JSONObject jso = new JSONObject();
		jso.put("id", this.id);
		jso.put("email", this.email);
		jso.put("name", this.name);
		return jso.toString();
	}

	/**
	 * Sets pwd.
	 *
	 * @param pwd the pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Gets picture.
	 *
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * Sets picture.
	 *
	 * @param picture the picture
	 */
	public void setPicture(byte[] picture) {
		byte[] b64 = Base64.getEncoder().encode(picture);
		this.picture = new String(b64);	
	}

	/**
	 * Sets picture.
	 *
	 * @param picture the picture
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@JsonIgnore
	public Long getConfirmationDate() {
		return confirmationDate;
	}

	/**
	 * Sets confirmation date.
	 *
	 * @param confirmationDate the confirmation date
	 */
	public void setConfirmationDate(Long confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	/**
	 * Sets session.
	 *
	 * @param wrapperSession the wrapper session
	 */
	public void setSession(WrapperSession wrapperSession) {
		this.session = wrapperSession;
	}

	/**
	 * Gets session.
	 *
	 * @return the session
	 */
	@JsonIgnore
	public WrapperSession getSession() {
		return session;
	}

	/**
	 * Send message.
	 *
	 * @param jso the jso
	 * @throws IOException the io exception
	 */
	public void
	sendMessage(JSONObject jso) throws IOException {
		WebSocketSession wsSession = this.session.getWsSession();
		try {
			wsSession.sendMessage(new TextMessage(jso.toString()));
		}catch (IllegalStateException e){
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Estamos cerrando la anterior sesión, haz click ahora de nuevo! ⏹");
		}
	}

	/**
	 * Sets cookie.
	 *
	 * @param value the value
	 */
	public void setCookie(String value) {
		this.cookie = cookie;
	}
}
