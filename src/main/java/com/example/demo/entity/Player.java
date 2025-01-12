package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @Column(nullable = false)
    private String playerName;

    @Column(nullable = false)
    private Integer userSelectionCount = 0;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false) // Ensuring a player belongs to a team
    private Team team;
    
    public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getUserSelectionCount() {
		return userSelectionCount;
	}

	public void setUserSelectionCount(Integer userSelectionCount) {
		this.userSelectionCount = userSelectionCount;
	}

	
	

}
