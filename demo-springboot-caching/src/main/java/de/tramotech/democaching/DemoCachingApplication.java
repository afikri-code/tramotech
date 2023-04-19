package de.tramotech.democaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Author: Ahmed Fikri
 */
@SpringBootApplication
@EnableCaching
public class DemoCachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCachingApplication.class, args);
    }

}
