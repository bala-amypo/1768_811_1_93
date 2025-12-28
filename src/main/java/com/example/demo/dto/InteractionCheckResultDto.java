package com.example.demo.dto;

import java.time.LocalDateTime;

public class InteractionCheckResultDto {

    private Long id;
    private String interactions;
    private LocalDateTime checkedAt;

    public InteractionCheckResultDto() {}

    public InteractionCheckResultDto(Long id, String interactions,
                                     LocalDateTime checkedAt) {
        this.id = id;
        this.interactions = interactions;
        this.checkedAt = checkedAt;
    }

    public Long getId() { return id; }
    public String getInteractions() { return interactions; }
    public LocalDateTime getCheckedAt() { return checkedAt; }

    public void setId(Long id) { this.id = id; }
    public void setInteractions(String interactions) { this.interactions = interactions; }
    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }
}
