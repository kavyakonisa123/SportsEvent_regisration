package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	
	@Modifying
    @Transactional
    @Query("UPDATE Team t SET t.userSelectionCount = t.userSelectionCount + 1 WHERE t.teamId = :teamId")
    void incrementSelectionCount(@Param("teamId") Long teamId);
	
    Team findTopByOrderByUserSelectionCountDesc();


}
