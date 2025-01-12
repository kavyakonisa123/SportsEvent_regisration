package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Modifying
    @Transactional
    @Query("UPDATE Event e SET e.userSelectionCount = e.userSelectionCount + 1 WHERE e.eventId = :eventId")
    void incrementSelectionCount(@Param("eventId") Long eventId);


}
