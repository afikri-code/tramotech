package de.tramotech.springbootkeycloakdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class for the Spring Boot Keycloak Demo Application.
 * It is responsible for initializing and running the Spring Boot application.
 *
 * The application is configured using the Spring Boot annotation @SpringBootApplication,
 * which combines @Configuration, @EnableAutoConfiguration, and @ComponentScan.
 * This annotation signifies that this class is the entry point for the Spring Boot application.
 *
 * To start the application, you can run the main method in this class.
 *
 * @see org.springframework.boot.SpringApplication#run(Class, String...)
 * @author Ahmed Fikri
 */
@SpringBootApplication
public class SpringbootKeycloakDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKeycloakDemoApplication.class, args);
    }

}
