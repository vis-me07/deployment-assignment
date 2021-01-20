package com.assignment.deployment.controller;

import com.assignment.deployment.dto.UserName;
import com.assignment.deployment.dto.WelcomeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping("/welcome")
    public ResponseEntity<WelcomeMessage> welcome(@RequestBody UserName userName) {
        WelcomeMessage message = new WelcomeMessage();
        message.setMessage("Hi " + userName.getName() + ", this is my deployment assignment");

        return ResponseEntity.ok(message);
    }
}
