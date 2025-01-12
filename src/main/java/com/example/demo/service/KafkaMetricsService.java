package com.example.demo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMetricsService {

    private final Timer kafkaConsumerLatencyTimer;
    private final Counter kafkaConsumerThroughputCounter;
    private final Counter kafkaProducerThroughputCounter;
    private final Timer kafkaProducerLatencyTimer;

    public KafkaMetricsService(MeterRegistry meterRegistry) {
        // Create metrics for consumer
        this.kafkaConsumerLatencyTimer = meterRegistry.timer("kafka.consumer.latency");
        this.kafkaConsumerThroughputCounter = meterRegistry.counter("kafka.consumer.throughput");

        // Create metrics for producer (assuming we have producer logic in this service)
        this.kafkaProducerLatencyTimer = meterRegistry.timer("kafka.producer.latency");
        this.kafkaProducerThroughputCounter = meterRegistry.counter("kafka.producer.throughput");
    }

    // Method that simulates message sending and records latency and throughput
    public void sendMessage(String topic, String message) {
        // Simulate message sending and record latency
        kafkaProducerLatencyTimer.record(() -> {
     
        });

        // Increment the throughput counter
        kafkaProducerThroughputCounter.increment();
    }

    @KafkaListener(topics = "yourTopic", groupId = "yourGroup")
    public void listen(ConsumerRecord<?, ?> record) {
        // Record the time taken to process the message for latency
        kafkaConsumerLatencyTimer.record(() -> {
            
        });

        // Increment the throughput counter
        kafkaConsumerThroughputCounter.increment();
    }

    // Other methods...
}
