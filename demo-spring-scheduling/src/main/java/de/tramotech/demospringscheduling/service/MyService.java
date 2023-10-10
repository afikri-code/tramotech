package de.tramotech.demospringscheduling.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Scheduled(fixedRate = 5000) // Schedule this method to run every 5 seconds
    public void callRestApi() {

        System.out.println("Received API response: " );
    }
}
