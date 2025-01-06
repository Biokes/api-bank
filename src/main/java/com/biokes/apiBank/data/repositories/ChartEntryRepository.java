package com.biokes.apiBank.data.repositories;

import com.biokes.apiBank.data.models.ChartEntryData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartEntryRepository extends JpaRepository<ChartEntryData, Long> {
}
