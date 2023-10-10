package de.tramotech.demospringscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoSpringSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSchedulingApplication.class, args);
    }

}
