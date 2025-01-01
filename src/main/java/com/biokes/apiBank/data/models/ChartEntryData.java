package com.biokes.apiBank.data.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChartEntryData {
    private Entry chartEntryData;
    private boolean missingRequiredFields;
    private TrackMetaData trackMetadata;
}
