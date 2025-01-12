package com.example.demo.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
public class KafkaConsumerToCSVService {
	
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerToCSVService.class);
    private final ObjectMapper objectMapper;


    @Value("${csv.output.path}")
    private String csvOutputPath;

    @Autowired
    public KafkaConsumerToCSVService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "user-registrations", groupId = "user-output-group")
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("Listening...");
        try {
            String jsonMessage = String.valueOf(record.value());
            writeToCSV(jsonMessage);
        } catch (Exception e) {
            logger.error("Error processing message: {}", e.getMessage(), e);
        }
    }

    private void writeToCSV(String data) {
        logger.info("Writing to CSV...");

        Path path = Path.of(csvOutputPath);
        boolean fileExists = Files.exists(path);

        try {
            // Ensure the directory exists
            Path parentDir = path.getParent();
            if (parentDir != null && Files.notExists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            // Log the absolute path to help find where the file is being written
            logger.info("CSV file path: {}", path.toAbsolutePath());

            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                 CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

                // Add header only if the file doesn't exist
                if (!fileExists) {
                    csvPrinter.printRecord("UserID", "Username", "Email", "RegistrationTime", "VisualizationTime",
                            "SelectedTeamId", "TeamName", "PlayerId", "PlayerName", "EventId", "EventName", "EventDate");
                }

                objectMapper.registerModule(new JavaTimeModule()); // To properly handle LocalDateTime
                User user = objectMapper.readValue(data, User.class);
                
            	csvPrinter.printRecord(user.getUserId(), user.getUsername(), user.getEmail(), 
            	                       user.getRegistrationTime().toString(), user.getVisualizationTime().toString(),
            	                       user.getSelectedTeamId().getTeamId(), user.getSelectedTeamId().getTeamName(),
            	                       user.getSelectedPlayerId().getPlayerId(), user.getSelectedPlayerId().getPlayerName(),
            	                       user.getSelectedEventId().getEventId(), user.getSelectedEventId().getEventName(),
            	                       user.getSelectedEventId().getEventDate().toString());
            	
            	csvPrinter.flush();
            }
        } catch (IOException e) {
            logger.error("Failed to write to CSV", e);
        }

    }
}
