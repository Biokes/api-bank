package com.biokes.apiBank.data.models;

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
