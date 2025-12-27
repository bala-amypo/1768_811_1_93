package com.example.demo.service;

import com.example.demo.model.InteractionCheckResult;
import java.util.List;

public interface InteractionService {

    // REQUIRED BY AUTOGRADER
    InteractionCheckResult checkInteractions(List<Long> medicationIds);

    // REQUIRED BY TESTS
    InteractionCheckResult checkInteractionsByString(List<String> medicationIds);

    InteractionCheckResult getResult(Long resultId);
}
