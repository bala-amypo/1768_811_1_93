package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interaction_rule")
public class InteractionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredienta_id", nullable = false)
    private ActiveIngredient ingredientA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredientb_id", nullable = false)
    private ActiveIngredient ingredientB;

    @Column(nullable = false)
    private String ruleDescription;

    // getters and setters
    public Long getId() {
        return id;
    }

    public ActiveIngredient getIngredientA() {
        return ingredientA;
    }

    public ActiveIngredient getIngredientB() {
        return ingredientB;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIngredientA(ActiveIngredient ingredientA) {
        this.ingredientA = ingredientA;
    }

    public void setIngredientB(ActiveIngredient ingredientB) {
        this.ingredientB = ingredientB;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }
}
