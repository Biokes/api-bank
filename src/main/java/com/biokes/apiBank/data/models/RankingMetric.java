package com.biokes.apiBank.data.models;

import jakarta.persistence.Embeddable;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Embeddable
public class RankingMetric {
    private String value;
    private String type;
}
