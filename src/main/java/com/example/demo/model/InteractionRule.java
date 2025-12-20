package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interaction_rules")
public class InteractionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActiveIngredient ingredientA;

    @ManyToOne
    private ActiveIngredient ingredientB;

    private String severity;
    private String description;

    public InteractionRule() {}

    public InteractionRule(ActiveIngredient a, ActiveIngredient b, String severity, String description) {
        this.ingredientA = a;
        this.ingredientB = b;
        this.severity = severity;
        this.description = description;
    }

    // getters & setters
}
