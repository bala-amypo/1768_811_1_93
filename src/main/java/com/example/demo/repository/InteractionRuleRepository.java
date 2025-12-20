package com.example.demo.repository;

import com.example.demo.model.InteractionRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRule, Long> {

    // Find rules where ingredientA = id OR ingredientB = id
    List<InteractionRule> findByIngredientA_IdOrIngredientB_Id(Long ingredientAId, Long ingredientBId);

    // Find rule between two specific ingredients
    Optional<InteractionRule> findByIngredientA_IdAndIngredientB_Id(Long ingredientAId, Long ingredientBId);
}
