package com.biokes.apiBank.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
public class RankingMetric {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
    private String type;
}
