package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackMetaData {
    @Id
    @GeneratedValue
    private Long id;
    private String trackName;
    private String trackUri;
    private String displayImageUri;
    @OneToMany
    private List<SpotifyWrap> artists;
    @OneToMany
    private List<SpotifyWrap> producers;
    @OneToMany
    private List<SpotifyWrap> labels;
    @OneToMany
    private List<SpotifyWrap> songWriters;
    private String releaseDate;
}
