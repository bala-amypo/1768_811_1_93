package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/rules")
@CrossOrigin
public class RuleController {

    private final List<Map<String, Object>> rules = new ArrayList<>();

    @PostMapping
    public Map<String, Object> addRule(@RequestBody Map<String, Object> body) {
        body.put("id", rules.size() + 1);
        rules.add(body);
        return body;
    }

    @GetMapping
    public List<Map<String, Object>> getAllRules() {
        return rules;
    }
}
