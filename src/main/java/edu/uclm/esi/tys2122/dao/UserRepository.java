package edu.uclm.esi.tys2122.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.uclm.esi.tys2122.model.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository <User, String> {

	/**
	 * Find by name and pwd user.
	 *
	 * @param name the name
	 * @param pwd  the pwd
	 * @return the user
	 */
	public User findByNameAndPwd(String name, String pwd);

	/**
	 * Find by name optional.
	 *
	 * @param name the name
	 * @return the optional
	 */
	public Optional<User> findByName(String name);

	/**
	 * Find by email user.
	 *
	 * @param email the email
	 * @return the user
	 */
	public User findByEmail(String email);

	/**
	 * Sets token from email.
	 *
	 * @param token the token
	 * @param email the email
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE user SET token= :token WHERE email= :email", nativeQuery = true)
	public void setTokenFromEmail(@Param("token") String token, @Param("email") String email);

	/**
	 * Find by token user.
	 *
	 * @param token the token
	 * @return the user
	 */
	public User findByToken(String token);

	/**
	 * Update pwd by id.
	 *
	 * @param pwd the pwd
	 * @param id  the id
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE user SET pwd= :pwd WHERE id= :id", nativeQuery = true)
	public void updatePwdById(@Param("pwd") String pwd, @Param("id") String id);

	/**
	 * Delete token after use.
	 *
	 * @param id the id
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE user SET token= null WHERE id= :id", nativeQuery = true)
	public void deleteTokenAfterUse(@Param("id") String id);

}
