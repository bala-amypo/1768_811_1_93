package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final MedicationRepository medicationRepository;
    private final InteractionRuleRepository ruleRepository;
    private final InteractionCheckResultRepository resultRepository;

    public InteractionServiceImpl(
            MedicationRepository medicationRepository,
            InteractionRuleRepository ruleRepository,
            InteractionCheckResultRepository resultRepository) {
        this.medicationRepository = medicationRepository;
        this.ruleRepository = ruleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {

        List<Medication> meds = medicationRepository.findAllById(medicationIds);

        if (meds.isEmpty()) {
            throw new IllegalArgumentException("No medications found");
        }

        List<ActiveIngredient> ingredients = meds.stream()
                .flatMap(m -> m.getIngredients().stream())
                .collect(Collectors.toList());

        List<String> foundInteractions = new ArrayList<>();

        for (int i = 0; i < ingredients.size(); i++) {
            for (int j = i + 1; j < ingredients.size(); j++) {

                ruleRepository.findRuleBetweenIngredients(
                        ingredients.get(i).getId(),
                        ingredients.get(j).getId()
                ).ifPresent(rule ->
                        foundInteractions.add(rule.getDescription())
                );
            }
        }

        InteractionCheckResult result =
                new InteractionCheckResult(
                        meds.stream().map(Medication::getName)
                                .collect(Collectors.joining(",")),
                        foundInteractions.toString()
                );

        return resultRepository.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Result not found"));
    }
}
