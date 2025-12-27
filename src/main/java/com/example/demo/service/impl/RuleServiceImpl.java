package com.example.demo.service.impl;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    public RuleServiceImpl() {}

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        return rule;
    }
}
