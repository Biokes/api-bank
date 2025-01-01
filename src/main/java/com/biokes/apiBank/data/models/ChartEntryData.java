package com.biokes.apiBank.data.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Embeddable
public class ChartEntryData {
    @Embedded
    private Entry chartEntryData;
    private boolean missingRequiredFields;
    @Embedded
    private TrackMetaData trackMetadata;
}
