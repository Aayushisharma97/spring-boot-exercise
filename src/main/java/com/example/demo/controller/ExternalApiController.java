package com.example.demo.controller;

import com.example.demo.service.ExternalApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/external")
public class ExternalApiController {

    private final ExternalApiService externalApiService;

    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/google")
    public ResponseEntity<String> callGoogle() {
        String response = externalApiService.callGoogle();
        return ResponseEntity.ok(response);
    }
}
