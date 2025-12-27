package com.example.demo.dto;

public class InteractionRuleDto {

    private Long ingredientAId;
    private Long ingredientBId;
    private String severity;
    private String description;

    public InteractionRuleDto() {}

    public InteractionRuleDto(Long ingredientAId, Long ingredientBId,
                              String severity, String description) {
        this.ingredientAId = ingredientAId;
        this.ingredientBId = ingredientBId;
        this.severity = severity;
        this.description = description;
    }

    public Long getIngredientAId() { return ingredientAId; }
    public Long getIngredientBId() { return ingredientBId; }
    public String getSeverity() { return severity; }
    public String getDescription() { return description; }

    public void setIngredientAId(Long ingredientAId) { this.ingredientAId = ingredientAId; }
    public void setIngredientBId(Long ingredientBId) { this.ingredientBId = ingredientBId; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setDescription(String description) { this.description = description; }
}
