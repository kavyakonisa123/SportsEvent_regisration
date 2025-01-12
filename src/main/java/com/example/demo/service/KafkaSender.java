package com.example.demo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Counter kafkaProducerCounter;
    private final Timer kafkaProducerLatencyTimer;


    @Autowired
    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate, MeterRegistry meterRegistry) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaProducerCounter = meterRegistry.counter("kafka.producer.messages.sent");
        this.kafkaProducerLatencyTimer = meterRegistry.timer("kafka.producer.latency");

    }

    public void send(String topic, String message) {
        kafkaProducerLatencyTimer.record(() -> kafkaTemplate.send(topic, message));
        // Increment the throughput counter
        kafkaProducerCounter.increment();
    }
}
