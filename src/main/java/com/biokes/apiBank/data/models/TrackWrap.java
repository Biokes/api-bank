package com.biokes.apiBank.data.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TrackWrap {
    private List<Track> tracks;
}
