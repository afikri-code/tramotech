package de.afikri.rest.quickdemo.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {
    @KafkaListener(topics ="my-topic", groupId = "spring-boot")
    public void readFromKafka(String message) {
        System.out.println("Message from Kafka: " + message);

    }
}
