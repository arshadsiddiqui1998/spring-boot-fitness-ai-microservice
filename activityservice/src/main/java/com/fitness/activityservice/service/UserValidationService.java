package com.fitness.activityservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationService {

    private final WebClient userServiceWebClient;

    public boolean validateUser(String userId) {
        try {
            log.info("Calling USERSERVICE via Eureka for userId={}", userId);

            Boolean result = userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

            log.info("Validation result for userId {} = {}", userId, result);
            return Boolean.TRUE.equals(result);

        } catch (WebClientResponseException e) {
            log.error("Validation failed for userId {}. Status: {}, Response: {}",
                    userId, e.getStatusCode(), e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            log.error("Unexpected error validating userId {}", userId, e);
        }
        return false;
    }
}
