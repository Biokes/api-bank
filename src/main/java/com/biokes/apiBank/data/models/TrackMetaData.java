package com.biokes.apiBank.data.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Embeddable
public class TrackMetaData {
    private String trackName;
    private String trackUri;
    private String displayImageUri;
    private List<Artist> artists;
    private List<String> producers;
    private List<Artist> labels;
    private List<String> songWriters;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDate releaseDate;
}
