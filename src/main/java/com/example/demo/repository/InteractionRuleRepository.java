package com.example.demo.repository;

import com.example.demo.model.InteractionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRule, Long> {

    @Query("""
SELECT r FROM InteractionRule r
WHERE r.ingredientA.id = :id OR r.ingredientB.id = :id
""")
List<InteractionRule> findByIngredientId(@Param("id") Long id);

   
}
