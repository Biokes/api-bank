package com.biokes.apiBank.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
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
    @ManyToOne
    private RankingMetric rankingMetric;
    private String entryStatus;
    private int entryRank;
    private String entryDate;
}
