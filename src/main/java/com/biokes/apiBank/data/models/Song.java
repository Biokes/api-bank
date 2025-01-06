package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne
    @JsonProperty("chartEntryData")
    private  ChartEntryData chartEntryData;
    @ManyToOne
    @JsonProperty("trackMetaData")
    private TrackMetaData trackMetaData;
    private boolean isLocalSong;
}