package com.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class NewsSentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticker;
    private BigDecimal sentimentScore;
    // Summary of the news article
    @Column(columnDefinition = "TEXT")
    private String summary;
    // Timestamp for the last update
    private LocalDateTime lastUpdated = LocalDateTime.now();
    // Update the timestamp before updating the entity
    @PreUpdate
    public void preUpdate() {
        lastUpdated = LocalDateTime.now();
    }
}
