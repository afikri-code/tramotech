package de.tramotech.springbootkeycloakdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling secure endpoints in the Spring Boot Keycloak Demo Application.
 * This class defines two secure endpoints: "/api" and "/authenticated".
 *
 * @author Ahmed Fikri
 */
@RestController
public class SecureController {

    /**
     * Handles requests to the "/api" endpoint.
     *
     * @return A greeting message for authenticated users accessing the "/api" endpoint.
     */
    @GetMapping("/api")
    public String api() {
        return "Hello, secured world!";
    }

    /**
     * Handles requests to the "/authenticated" endpoint.
     *
     * @return A response indicating that the user is authenticated.
     */
    @GetMapping("/authenticated")
    public String secured() {
        return "authenticated";
    }
}

