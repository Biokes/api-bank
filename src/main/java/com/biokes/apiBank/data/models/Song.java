package com.biokes.apiBank.data.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private boolean missingRequiredFields;
    @ManyToOne
    private  ChartEntryData chartEntryData;
    @ManyToOne
    private TrackMetaData trackMetaData;
    private boolean isLocalSong;
}