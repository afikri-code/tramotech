package de.tramotech;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

/**
 * Hello world!
 *
 */
public class RestClientUsingWebClient
{
    public static void main(String[] args) {
        // Basic authentication credentials
        String username = "admin";
        String password = "admin";

        String basicUrl = "http://localhost:8080";

        // Create the WebClient instance as per the provided code
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", basicUrl))
                .build();

        // Send a synchronous GET request with basic authentication
        String jsonResponse = client
                .get()
                .uri("/api/users/1") // Replace with the actual endpoint you want to request
                .headers(headers -> headers.setBasicAuth(username, password)) // Add basic authentication
                .exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    } else {
                        return response.createException()
                                .flatMap(Mono::error);
                    }
                })
                .block(); // This blocks the current thread until the response is available

        // Print the JSON response
        System.out.println("JSON Response:");
        System.out.println(jsonResponse);
    }

}
