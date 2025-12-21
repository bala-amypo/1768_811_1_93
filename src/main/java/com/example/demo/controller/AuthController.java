package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {
        return Map.of(
                "message", "User registered successfully",
                "email", body.getOrDefault("email", "unknown")
        );
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        return Map.of(
                "message", "Login successful",
                "email", body.getOrDefault("email", "unknown")
        );
    }
}
