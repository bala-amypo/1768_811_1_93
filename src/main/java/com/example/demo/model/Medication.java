package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Set<ActiveIngredient> ingredients = new HashSet<>();

    public Medication() {}
    public Medication(String name) { this.name = name; }

    // getters & setters
}
