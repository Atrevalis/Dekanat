package com.dekanat.dekanat.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
