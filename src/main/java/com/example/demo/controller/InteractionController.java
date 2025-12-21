package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/interact")
@CrossOrigin
public class InteractionController {

    private final Map<Integer, Map<String, Object>> results = new HashMap<>();
    private int counter = 1;

    @PostMapping("/check")
    public Map<String, Object> checkInteraction(@RequestBody Map<Stringi<Map<String, Object>> body) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", counter);
        result.put("status", "No severe interaction found");
        result.put("input", body);

        results.put(counter, result);
        counter++;

        return result;
    }

    @GetMapping("/result/{id}")
    public Map<String, Object> getResult(@PathVariable int id) {
        return results.getOrDefault(id, Map.of("error", "Result not found"));
    }
}
