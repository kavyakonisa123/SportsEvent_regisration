package com.example.demo.controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Event;
import com.example.demo.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/register")
    public String showEventRegistrationForm() {
        return "eventRegistration"; // Assumes you have a JSP form for event registration
    }

    @PostMapping("/register")
    public String processEventRegistration(@RequestParam("eventName") String eventName,
                                           @RequestParam("eventDate") String eventDate) {
        Event newEvent = new Event();
        newEvent.setEventName(eventName);
        newEvent.setEventDate(LocalDate.parse(eventDate)); // Assuming the date is submitted as a String
        eventService.saveEvent(newEvent);
        return "redirect:/events/list";
    }

    @GetMapping("/list")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "eventsList"; // Assumes you have a JSP page for listing events
    }
}