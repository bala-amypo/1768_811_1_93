package com.example.demo.repository;

import com.example.demo.model.InteractionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRule, Long> {

    // ✅ FIXED — WORKS AT RUNTIME
    @Query("""
        SELECT r FROM InteractionRule r
        WHERE r.ingredientA.id = :ingredientId
           OR r.ingredientB.id = :ingredientId
    """)
    List<InteractionRule> findByIngredientId(
            @Param("ingredientId") Long ingredientId
    );

    // already used by service
    Optional<InteractionRule> findRuleBetweenIngredients(Long aId, Long bId);
}
