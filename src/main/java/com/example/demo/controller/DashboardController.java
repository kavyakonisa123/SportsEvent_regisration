package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.example.demo.entity.UserRegistrationDetail;
import com.example.demo.service.DashboardService;
import com.example.demo.service.MessageStorageService;

@Controller
public class DashboardController {
    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private DashboardService dashboardService;
    
    @Autowired
    private MessageStorageService messageStorageService;

  

    @GetMapping("/dashboard")
    public String showDashboard(Model model)  {
    	try {
            dashboardService.prepareDataForVisualization(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        log.info("getHighestSelectedPlayer: {}", dashboardService.getHighestSelectedPlayer());
        log.info("getHighestSelectedTeam: {}", dashboardService.getHighestSelectedTeam());
        model.addAttribute("highestSelectedPlayer", dashboardService.getHighestSelectedPlayer());
        model.addAttribute("highestSelectedTeam", dashboardService.getHighestSelectedTeam());
        model.addAttribute("userRegistrations", dashboardService.getAllUserRegistrations());
        List<UserRegistrationDetail> registrationMessages = messageStorageService.getAllMessages();
        model.addAttribute("registrationMessages", registrationMessages);
        
        return "dashboard";
        }

}

