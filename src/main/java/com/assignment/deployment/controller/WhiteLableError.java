package com.assignment.deployment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhiteLableError {

    @GetMapping("/")
    public String home() {
        return "Welcome to Deployment Assignment";
    }
}
