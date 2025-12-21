package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/catalog")
@CrossOrigin
public class CatalogController {

    private final List<Map<String, Object>> ingredients = new ArrayList<>();
    private final List<Map<String, Object>> medications = new ArrayList<>();

    @PostMapping("/ingredient")
    public Map<String, Object> addIngredient(@RequestBody Map<String, Object> body) {
        body.put("id", ingredients.size() + 1);
        ingredients.add(body);
        return body;
    }

    @PostMapping("/medication")
    public Map<String, Object> addMedication(@RequestBody Map<String, Object> body) {
        body.put("id", medications.size() + 1);
        medications.add(body);
        return body;
    }

    @GetMapping("/medications")
    public List<Map<String, Object>> getAllMedications() {
        return medications;
    }
}
