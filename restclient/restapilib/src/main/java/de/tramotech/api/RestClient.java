package de.tramotech.api;

import org.springframework.http.HttpMethod;

public interface RestClient {
    void addCredentials(String username, String password);
    String executeRequest(String endpoint, HttpMethod method, String requestBody) throws Exception;
}
