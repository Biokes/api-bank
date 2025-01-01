package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entry {
    private int currentRank;
    private int previousRank;
    private int peakRank;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date peakDate;
    private int appearancesOnChart;
    private int consecutiveAppearancesOnChart;
    private RankingMetric rankingMetric;
    private String entryStatus;
    private int entryRank;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date entryDate;

}