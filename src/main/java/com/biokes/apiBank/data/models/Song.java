package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.CascadeType.ALL;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Song {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("missingRequiredFields")
    private boolean missingRequiredFields;

    @OneToOne(cascade = ALL)
    @JsonProperty("chartEntryData")
    @JoinColumn(name = "chart_entry_data_id")
    private  ChartEntryData chartEntryData;

    @OneToOne(cascade = ALL)
    @JsonProperty("trackMetadata")
    @JoinColumn(name = "track_meta_data_id")
    private TrackMetaData trackMetaData;

    private boolean isLocalSong;
}