package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChartEntryData {
    @Id
    @GeneratedValue
    private Long id;
    private int currentRank;
    private int previousRank;
    private int peakRank;
    private String peakDate;
    private int appearancesOnChart;
    private int consecutiveAppearancesOnChart;
    @ManyToOne(cascade = ALL)
    private RankingMetric rankingMetric;
    private String entryStatus;
    private int entryRank;
    private String entryDate;
}
