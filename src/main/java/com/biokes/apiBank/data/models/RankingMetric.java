package com.biokes.apiBank.data.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RankingMetric {
    private String value;
    private String type;
}
