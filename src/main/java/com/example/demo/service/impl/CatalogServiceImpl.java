package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {

    public CatalogServiceImpl() {}

    @Override
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        return ingredient;
    }

    @Override
    public Medication addMedication(Medication medication) {
        return medication;
    }
}
