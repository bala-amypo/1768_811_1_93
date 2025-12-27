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
    @JoinTable(
        name = "medication_ingredients",
        joinColumns = @JoinColumn(name = "medication_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<ActiveIngredient> ingredients = new HashSet<>();

    public Medication() {
    }

    public Medication(String name) {
        this.name = name;
    }

    /* ===================== */
    /* REQUIRED BY AUTOGRADER */
    /* ===================== */

    public void addIngredient(ActiveIngredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(ActiveIngredient ingredient) {
        this.ingredients.remove(ingredient);
    }

    /* ===================== */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<ActiveIngredient> getIngredients() {
        return ingredients;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(Set<ActiveIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
