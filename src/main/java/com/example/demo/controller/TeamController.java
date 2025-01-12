package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Team;
import com.example.demo.service.TeamService;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/register")
    public String showTeamRegistrationForm() {
        return "teamRegistration"; 
    }

    @PostMapping("/register")
    public String processTeamRegistration(@RequestParam("teamName") String teamName) {
        Team newTeam = new Team();
        newTeam.setTeamName(teamName);
        teamService.saveTeam(newTeam);
        return "redirect:/teams/list";
    }

    @GetMapping("/list")
    public String listTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "teamsList"; 
    }
}