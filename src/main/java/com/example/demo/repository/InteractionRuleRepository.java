package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface InteractionRuleRepository extends JpaRepository<InteractionRule, Long> {
    List<InteractionRule> findByIngredientId(Long id);
    Optional<InteractionRule> findRuleBetweenIngredients(Long a, Long b);
}

