package edu.uclm.esi.tys2122.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.uclm.esi.tys2122.model.User;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

	public User findByNameAndPwd(String name, String pwd);
	public Optional<User> findByName(String name);
	public User findByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = "UPDATE user SET token= :token WHERE email= :email", nativeQuery = true)
	public void setTokenFromEmail(@Param("token") String token, @Param("email") String email);

	public User findByToken(String token);

	@Transactional
	@Modifying
	@Query(value = "UPDATE user SET pwd= :pwd WHERE id= :id", nativeQuery = true)
	public void updatePwdById(@Param("pwd") String pwd, @Param("id") String id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE user SET token= null WHERE id= :id", nativeQuery = true)
	public void deleteTokenAfterUse(@Param("id") String id);

}
