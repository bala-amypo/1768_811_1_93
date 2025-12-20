package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interaction_results")
public class InteractionCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medications;

    @Column(columnDefinition = "TEXT")
    private String interactions;

    private LocalDateTime checkedAt;

    @PrePersist
    void onCreate() {
        checkedAt = LocalDateTime.now();
    }

    public InteractionCheckResult() {}

    public InteractionCheckResult(String meds, String interactions) {
        this.medications = meds;
        this.interactions = interactions;
    }

    // getters & setters
}
