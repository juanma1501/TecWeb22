package edu.uclm.esi.tys2122.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uclm.esi.tys2122.model.Movement;

public interface MovementRepository extends JpaRepository <Movement, String> {

}
