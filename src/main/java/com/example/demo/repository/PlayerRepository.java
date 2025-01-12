package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	@Modifying
    @Transactional
    @Query("UPDATE Player p SET p.userSelectionCount = p.userSelectionCount + 1 WHERE p.playerId = :playerId")
    void incrementSelectionCount(@Param("playerId") Long playerId);

    Player findTopByOrderByUserSelectionCountDesc();

	
	
}
