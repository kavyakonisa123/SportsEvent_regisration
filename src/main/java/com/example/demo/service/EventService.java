package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepository;

@Service
public class EventService {

	private final EventRepository eventRepository;

	@Autowired
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	public Event saveEvent(Event event) {
		return eventRepository.save(event); // Save the event entity to the database
	}
}
