package com.example.demo.entity;

import java.time.LocalDateTime;

public class UserRegistration {
    private int userId;
    private String username;
    private String email;
    private LocalDateTime registrationTime;
    private LocalDateTime visualizationTime;
    private int selectedTeamId;
    private String teamName;
    private int playerId;
    private String playerName;
    private int eventId;
    private String eventName;
    private String eventDate;

    // Getters and setters for each field

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public LocalDateTime getVisualizationTime() {
        return visualizationTime;
    }

    public void setVisualizationTime(LocalDateTime visualizationTime) {
        this.visualizationTime = visualizationTime;
    }

    public int getSelectedTeamId() {
        return selectedTeamId;
    }

    public void setSelectedTeamId(int selectedTeamId) {
        this.selectedTeamId = selectedTeamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
    
    // toString method for easy printing/logging
    @Override
    public String toString() {
        return "UserRegistration{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", registrationTime=" + registrationTime +
                ", visualizationTime=" + visualizationTime +
                ", selectedTeamId=" + selectedTeamId +
                ", teamName='" + teamName + '\'' +
                ", playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                '}';
    }
}
