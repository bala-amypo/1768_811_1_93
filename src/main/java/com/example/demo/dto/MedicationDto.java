package com.example.demo.dto;

import java.util.Set;

public class MedicationDto {

    private Long id;
    private String name;
    private Set<Long> ingredientIds;

    public MedicationDto() {}

    public MedicationDto(Long id, String name, Set<Long> ingredientIds) {
        this.id = id;
        this.name = name;
        this.ingredientIds = ingredientIds;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Set<Long> getIngredientIds() { return ingredientIds; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setIngredientIds(Set<Long> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }
}
