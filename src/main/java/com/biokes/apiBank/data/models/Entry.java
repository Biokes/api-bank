package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Entry {
    private int currentRank;
    private int previousRank;
    private int peakRank;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDate peakDate;
    private int appearancesOnChart;
    private int consecutiveAppearancesOnChart;
    @Embedded
    private RankingMetric rankingMetric;
    private String entryStatus;
    private int entryRank;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDate entryDate;

}