package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

	private final UserRepository userRepository;
	private TeamRepository teamRepository; 
	private EventRepository eventRepository;
	private PlayerRepository playerRepository;
	    

	@Autowired
    public UserService(UserRepository userRepository, TeamRepository teamRepository,
                       EventRepository eventRepository, PlayerRepository playerRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.eventRepository = eventRepository;
        this.playerRepository = playerRepository;
    }
    
    @Transactional
    public void saveUser(User user) {
        // Perform any additional logic or validations here
    	user.setRegistrationTime(new Date());
        user.setVisualizationTime(new Date());
        userRepository.save(user);
        
     // Increment selection counts if selections are present
        if (user.getSelectedTeamId() != null) {
            teamRepository.incrementSelectionCount(user.getSelectedTeamId().getTeamId());
        }
        if (user.getSelectedEventId() != null) {
            eventRepository.incrementSelectionCount(user.getSelectedEventId().getEventId());
        }
        if (user.getSelectedPlayerId() != null) {
            playerRepository.incrementSelectionCount(user.getSelectedPlayerId().getPlayerId());
        }
        
        
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    
    
}
