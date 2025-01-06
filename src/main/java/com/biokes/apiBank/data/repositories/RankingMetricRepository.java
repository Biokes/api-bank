package com.biokes.apiBank.data.repositories;

import com.biokes.apiBank.data.models.RankingMetric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingMetricRepository extends JpaRepository<RankingMetric, Long> {
}

