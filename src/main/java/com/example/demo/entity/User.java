package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Date registrationTime;

    private Date visualizationTime;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team selectedTeamId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player selectedPlayerId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event selectedEventId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Date getVisualizationTime() {
		return visualizationTime;
	}

	public void setVisualizationTime(Date visualizationTime) {
		this.visualizationTime = visualizationTime;
	}

	public Team getSelectedTeamId() {
		return selectedTeamId;
	}

	public void setSelectedTeamId(Team selectedTeamId) {
		this.selectedTeamId = selectedTeamId;
	}

	public Player getSelectedPlayerId() {
		return selectedPlayerId;
	}

	public void setSelectedPlayerId(Player selectedPlayerId) {
		this.selectedPlayerId = selectedPlayerId;
	}

	public Event getSelectedEventId() {
		return selectedEventId;
	}

	public void setSelectedEventId(Event selectedEventId) {
		this.selectedEventId = selectedEventId;
	}

}
