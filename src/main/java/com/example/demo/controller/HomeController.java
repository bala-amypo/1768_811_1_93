package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Application is running";
    }
}
