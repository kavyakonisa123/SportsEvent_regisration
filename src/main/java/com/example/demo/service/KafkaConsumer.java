package com.example.demo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private final Counter kafkaConsumerCounter;

    @Autowired
    private MessageStorageService messageStorageService;

    @Autowired
    public KafkaConsumer(MeterRegistry meterRegistry) {
        this.kafkaConsumerCounter = meterRegistry.counter("kafka.consumer.messages.received");
    }

    @KafkaListener(topics = "user-registrations", groupId = "user-registration-group")
    public void listen(String message) {
        System.out.println("Received message in group user-registration-group: " + message);
        // Increment the throughput counter
        kafkaConsumerCounter.increment();
        messageStorageService.addMessage(message);

    }
}
