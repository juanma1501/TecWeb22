package edu.uclm.esi.tys2122.dao;

import edu.uclm.esi.tys2122.model.Match;
import edu.uclm.esi.tys2122.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Match repository.
 */
public interface MatchRepository extends JpaRepository<Match, String> {

    /**
     * Save match.
     *
     * @param id     the id
     * @param game   the game
     * @param looser the looser
     * @param winner the winner
     * @param draw   the draw
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO partida (id, game, looser_id, winner_id, draw) VALUES (:id, :game, :looser, :winner, :draw)", nativeQuery = true)
    public void saveMatch(String id, String game, User looser, User winner, boolean draw);

    /**
     * Get statistics object [ ].
     *
     * @param id the id
     * @return the object [ ]
     */
    @Query (value = "SELECT COUNT(IF(looser_id=:id && game='TictactoeMatch',1, null)) as looserTicTacToe, COUNT(IF(winner_id=:id && game='TictactoeMatch',1, null)) as winnerTicTacToe, COUNT(IF(looser_id=:id && game='StonePaperScissorMatch',1, null)) as looserPPT, COUNT(IF(winner_id=:id && game='StonePaperScissorMatch',1, null)) as winnerPPT  FROM juegos.partida", nativeQuery = true)
    public Object[] getStatistics(String id);

}
