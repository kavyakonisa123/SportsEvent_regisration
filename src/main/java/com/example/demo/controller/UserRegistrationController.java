package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;



import com.example.demo.entity.Player;
import com.example.demo.entity.Team;
import com.example.demo.entity.User;
import com.example.demo.entity.Event;
import com.example.demo.service.EventService;
import com.example.demo.service.KafkaSender;
import com.example.demo.service.PlayerService;
import com.example.demo.service.TeamService;
import com.example.demo.service.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@Controller
public class UserRegistrationController {
	
	private final UserService userService;
	private final TeamService teamService;
    private final PlayerService playerService;
    private final EventService eventService;
    @Autowired
    private KafkaSender kafkaSender;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public UserRegistrationController(UserService userService,TeamService teamService, PlayerService playerService,EventService eventService) {
        this.userService = userService;
        this.teamService = teamService;
        this.playerService = playerService;
        this.eventService= eventService;
    }
    
    @PostConstruct
    public void setup() {
        objectMapper.registerModule(new JavaTimeModule());
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        List<Team> teams = teamService.getAllTeams(); 
        List<Player> players = playerService.getAllPlayers(); 
        List<Event> events = eventService.getAllEvents();

        // Add these lists to the model so they can be used in the form
        model.addAttribute("teams", teams);
        model.addAttribute("players", players);
        model.addAttribute("events", events);

        // If the form should pre-select any team or player -- default value
        model.addAttribute("selectedTeamId", 1);
        model.addAttribute("selectedPlayerId", 1);
        model.addAttribute("selectedEventId", 1);

        // Add a new User object to the model to store form inputs
        model.addAttribute("user", new User());

        return "register"; 
    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("user") User user,
                                      BindingResult result,
                                      Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        
        userService.saveUser(user);

        
        try {
        	objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String jsonData = objectMapper.writeValueAsString(user);
            kafkaSender.send("user-registrations", jsonData);
        } catch (JsonProcessingException e) {
            // Handle JSON serialization errors
            System.out.println("JSON serialization error: " + e.getMessage());
            // Log the error, alert admin or take appropriate actions
            model.addAttribute("error", "There was a problem processing your registration.");
            return "register";
        } catch (Exception e) {
            // Handle Kafka sending errors
            System.out.println("Kafka sending error: " + e.getMessage());
            // Log the error, alert admin or take appropriate actions
            model.addAttribute("error", "There was a problem sending your registration to our systems.");
            return "register";
        }       
        

        // Optionally add attributes for the success page or you can redirect to prevent double posting
        model.addAttribute("registrationSuccess", true);
        return "redirect:/dashboard";
    }


}
