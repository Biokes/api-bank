package com.biokes.apiBank.data.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song {
    private ChartEntryData data;
    private boolean isGlobalSong;
}
