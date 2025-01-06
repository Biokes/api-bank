package com.biokes.apiBank.data.repositories;

import com.biokes.apiBank.data.models.TrackMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackMetaDataRepository extends JpaRepository<TrackMetaData, Long> {
}
