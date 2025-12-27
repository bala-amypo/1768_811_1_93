package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "active_ingredient")
public class ActiveIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
