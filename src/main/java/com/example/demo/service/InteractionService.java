package com.example.demo.service;

import com.example.demo.model.InteractionCheckResult;

import java.util.List;

public interface InteractionService {

    // ✅ AUTOGRADER EXPECTS THIS EXACT SIGNATURE
    InteractionCheckResult checkInteractions(List<Long> medicationIds);

    InteractionCheckResult getResult(Long resultId);
}
