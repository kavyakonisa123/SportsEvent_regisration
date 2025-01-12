package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.demo.entity.Player;
import com.example.demo.entity.Team;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRegistration;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.repository.UserRepository;

@Service
public class DashboardService {
	
	 private final CSVService csvService;
	 private final ObjectMapper objectMapper;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;
    
 // Constructor with autowired CSVService
    public DashboardService(CSVService csvService, ObjectMapper objectMapper) {
        this.csvService = csvService;
        this.objectMapper = objectMapper;
    }

    public void prepareDataForVisualization(Model model) throws JsonProcessingException {
        List<UserRegistration> registrations = csvService.parseCSV("registered_users.csv");

        Map<LocalDate, Integer> registrationCounts = registrations.stream()
            .collect(Collectors.groupingBy(
                registration -> registration.getRegistrationTime().toLocalDate(),
                Collectors.summingInt(e -> 1) // count each registration as 1
            ));

        List<String> dates = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        registrationCounts.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                dates.add(entry.getKey().toString());
                counts.add(entry.getValue());
            });

        String datesJson = objectMapper.writeValueAsString(dates);
        String countsJson = objectMapper.writeValueAsString(counts);

        model.addAttribute("datesJson", datesJson);
        model.addAttribute("countsJson", countsJson);
    }

    
    public Player getHighestSelectedPlayer() {
        return playerRepository.findTopByOrderByUserSelectionCountDesc();
    }

    public Team getHighestSelectedTeam() {
        return teamRepository.findTopByOrderByUserSelectionCountDesc();
    }

    public List<User> getAllUserRegistrations() {
        return userRepository.findAll();
    }
   


}
