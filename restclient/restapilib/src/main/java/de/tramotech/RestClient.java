package de.tramotech;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

import org.springframework.http.*;

public class RestClient {
    private final String baseUrl;
    private final RestTemplate restTemplate;
    private final HttpHeaders headers;

    public RestClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.restTemplate = new RestTemplate();
        this.headers = new HttpHeaders();
    }

    public void addCredentials(String username, String password) {
        String credentials = username + ":" + password;
        byte[] base64Credentials = Base64.getEncoder().encode(credentials.getBytes());
        headers.add("Authorization", "Basic " + new String(base64Credentials));
    }

    public String get(String endpoint) throws Exception {
        String url = baseUrl + "/" + endpoint;
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("GET request failed with status code: " + response.getStatusCodeValue());
        }
    }

    public String post(String endpoint, String requestBody) throws Exception {
        String url = baseUrl + "/" + endpoint;
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("POST request failed with status code: " + response.getStatusCodeValue());
        }
    }

    public String executeRequest(String endpoint, HttpMethod method, String requestBody) throws Exception {
        String url = baseUrl + "/" + endpoint;
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                method,
                requestEntity,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception(method + " request failed with status code: " + response.getStatusCodeValue());
        }
    }

    public static void main(String[] args) {
        try {
            RestClient client = new RestClient("http://localhost:8080");

            // Add credentials if needed
            client.addCredentials("admin", "admin");

            String jsonResponse = client.get("/api/users/1");
            System.out.println(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



