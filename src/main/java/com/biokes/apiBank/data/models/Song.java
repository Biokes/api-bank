package com.biokes.apiBank.data.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Long id;
    @Embedded
    private ChartEntryData data;
    private boolean isGlobalSong;
}
