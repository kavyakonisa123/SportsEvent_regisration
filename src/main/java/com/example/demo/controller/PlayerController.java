package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Player;
import com.example.demo.service.PlayerService;

@Controller
@RequestMapping("/players") // This specifies that all paths in this controller are prefixed with "/players"
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/register")
    public String showPlayerRegistrationForm(Model model) {
        return "playerRegistration"; // Return the JSP page that contains the player registration form
    }

    @PostMapping("/register")
    public String processPlayerRegistration(@RequestParam("playerName") String playerName,
                                            @RequestParam("teamId") Long teamId) {
        Player newPlayer = new Player();
        newPlayer.setPlayerName(playerName);
        playerService.savePlayer(newPlayer,teamId);

        return "redirect:/players/list"; 
    }

    @GetMapping("/list")
    public String listPlayers(Model model) {
        // Use playerService to fetch all players and add them to the model
        model.addAttribute("players", playerService.getAllPlayers());
        return "playersList"; // Return the JSP page that lists all players
    }
}
