package edu.uclm.esi.tys2122.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uclm.esi.tys2122.model.Token;

/**
 * The interface Token repository.
 */
public interface TokenRepository extends JpaRepository<Token, String> {

}
