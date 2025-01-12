package com.example.demo.entity;

public class UserRegistrationDetail {
    private Long userId;
    private String username;
    private String email;
    // Assuming you have appropriate classes for these as well
    private Team selectedTeamId;
    private Player selectedPlayerId;
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
