package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ActiveIngredientRepository extends JpaRepository<ActiveIngredient, Long> {
    Optional<ActiveIngredient> findByName(String name);
    boolean existsByName(String name);
}
