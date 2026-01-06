package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {

    private final WebClient webClient;

    public ExternalApiServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String callGoogle() {
        return webClient.get()
                .uri("https://www.google.com")
                .retrieve()
                .bodyToMono(String.class)
                .onErrorReturn("External API call failed")
                .block();
    }
}
