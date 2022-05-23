package edu.uclm.esi.tys2122.dao;

import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MatchRepository extends JpaRepository<Match, String> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO battle (dtype,id,looser_id, winner_id, draw) VALUES (:game, :id, :looser, :winner, :draw)", nativeQuery = true)
    public void saveMatch(String game, String id, User looser, User winner, boolean draw);

}
