package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class InteractionCheckResult {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medications;

    @Column(columnDefinition = "TEXT")
    private String interactions;

    private LocalDateTime checkedAt = LocalDateTime.now();

    public InteractionCheckResult() {}

    public InteractionCheckResult(String meds, String interactions) {
        this.medications = meds;
        this.interactions = interactions;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMedications() { return medications; }
    public void setMedications(String medications) { this.medications = medications; }

    public String getInteractions() { return interactions; }
    public void setInteractions(String interactions) { this.interactions = interactions; }

    public LocalDateTime getCheckedAt() { return checkedAt; }
}
