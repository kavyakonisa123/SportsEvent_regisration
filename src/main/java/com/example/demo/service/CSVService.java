package com.example.demo.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.entity.UserRegistration;

import org.springframework.stereotype.Service;


@Service
public class CSVService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");

    public List<UserRegistration> parseCSV(String CSV_FILE_PATH) {
        List<UserRegistration> registrations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line = br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split by comma
                if (values.length >= 12) {
                    UserRegistration registration = new UserRegistration();
                    registration.setUserId(Integer.parseInt(values[0].trim()));
                    registration.setUsername(values[1].trim());
                    registration.setEmail(values[2].trim());
                    registration.setRegistrationTime(LocalDateTime.parse(values[3].trim(), formatter));
                    registration.setVisualizationTime(LocalDateTime.parse(values[4].trim(), formatter));
                    registration.setSelectedTeamId(Integer.parseInt(values[5].trim()));
                    registration.setTeamName(values[6].trim());
                    registration.setPlayerId(Integer.parseInt(values[7].trim()));
                    registration.setPlayerName(values[8].trim());
                    registration.setEventId(Integer.parseInt(values[9].trim()));
                    registration.setEventName(values[10].trim());
                    registration.setEventDate(values[11].trim()); 
                    
                    registrations.add(registration);
                } else {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registrations;
    }
}