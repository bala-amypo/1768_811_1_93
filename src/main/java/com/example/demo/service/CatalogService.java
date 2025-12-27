package com.example.demo.service;

import com.example.demo.model.*;

public interface CatalogService {
    ActiveIngredient addIngredient(ActiveIngredient ingredient);
    Medication addMedication(Medication medication);
}
