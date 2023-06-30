package com.leitnick.PacePursuit.service;
import com.leitnick.PacePursuit.util.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leitnick.PacePursuit.model.ApiKey;
import com.leitnick.PacePursuit.model.Run;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class StravaService {

    private static final String API_BASE_URL = "https://www.strava.com/api/v3";
    private static final String API_TOKEN_URL = "https://www.strava.com/api/v3/oauth/token";
    private static final int CLIENT_ID = 109828;
    private static final String CLIENT_SECRET = "3a1d7d85829be610f995d33ab971ef394c783d14";
    private static final int MY_ATHLETE_ID = 91776078;
    private final RestTemplate restTemplate = new RestTemplate();
    private ApiKey apiKey;

    public StravaService(ApiKey apiKey) {
        this.apiKey = apiKey;
    }

    public List<Run> listOfRuns() {
        List<Run> runList = new ArrayList<>();
        HttpEntity<String> entity = makeEntityForGet();
        try {
            ResponseEntity<List<Run>> response =
                    restTemplate.exchange(
                            API_BASE_URL + "/athletes/" + MY_ATHLETE_ID + "/activities",
                            HttpMethod.GET, entity,
                            new ParameterizedTypeReference<List<Run>>() {});
            runList = response.getBody();
        } catch (RestClientResponseException e) {
            Logger.log(e.getStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            Logger.log(e.getMessage());
        }
        return runList;
    }

    public ApiKey refreshApiToken() {
        HttpClient client = HttpClient.newHttpClient();
        String bodyContent = String.format(
                "client_id=%s&client_secret=%s&grant_type=refresh_token&refresh_token=%s",
                CLIENT_ID, CLIENT_SECRET, apiKey.getRefreshToken());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_TOKEN_URL))
                .POST(HttpRequest.BodyPublishers.ofString(bodyContent))
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            apiKey = objectMapper.readValue(response.body(), ApiKey.class);
            //TODO: Handle exception correctly
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        apiKey.setServiceName("Strava");
        return apiKey;
    }

    public boolean isApiTokenActive(ApiKey apiKey) {
        long currentTime = Instant.now().getEpochSecond();
        long expiration = apiKey.getExpiration();
        boolean isActive = expiration > currentTime;
        return isActive;
    }

    private HttpEntity<Run> makeEntity(Run run) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey.getAccessToken());
        return new HttpEntity<>(run, headers);
    }

    private HttpEntity<String> makeEntityForGet() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey.getAccessToken());
        return new HttpEntity<>("", headers);
    }


}
