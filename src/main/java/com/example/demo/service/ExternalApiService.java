package com.example.demo.service;

/**
 * Service interface for interacting with external APIs.
 *
 * <p>
 * Defines operations for fetching data from third-party systems.
 * Implementation should handle exceptions and return graceful defaults.
 * </p>
 */
public interface ExternalApiService {

    /**
     * Calls the Google homepage and returns the response body.
     *
     * @return the response from the external API, or a fallback message
     */
    String callGoogle();
}
