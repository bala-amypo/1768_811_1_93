package com.example.demo.repository;

import com.example.demo.model.InteractionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRule, Long> {

    @Query("""
        SELECT r FROM InteractionRule r
        WHERE r.ingredientA.id = :ingredientId
           OR r.ingredientB.id = :ingredientId
    """)
    List<InteractionRule> findByIngredientId(Long ingredientId);

    @Query("""
        SELECT r FROM InteractionRule r
        WHERE (r.ingredientA.id = :id1 AND r.ingredientB.id = :id2)
           OR (r.ingredientA.id = :id2 AND r.ingredientB.id = :id1)
    """)
    Optional<InteractionRule> findRuleBetweenIngredients(Long id1, Long id2);
}
