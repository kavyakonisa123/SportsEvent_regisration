package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Team;
import com.example.demo.repository.TeamRepository;

@Service
public class TeamService {
	
	private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    
    public Team saveTeam(Team team) {
        return teamRepository.save(team); // Save the team entity to the database
    }

    
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

}
