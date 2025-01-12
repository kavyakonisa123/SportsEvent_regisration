package com.example.demo.service;
import com.example.demo.entity.UserRegistrationDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageStorageService {

    private final List<UserRegistrationDetail> messages = new LinkedList<>();
    private final ObjectMapper objectMapper;

    @Autowired
    public MessageStorageService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    public void addMessage(String jsonMessage) {
        try {
            UserRegistrationDetail message = objectMapper.readValue(jsonMessage, UserRegistrationDetail.class);
            messages.add(message);
        } catch (Exception e) {
            // Handle exception
        }
    }

    public List<UserRegistrationDetail> getAllMessages() {
        return messages;
    }

    public void clear() {
        messages.clear();
    }
}
