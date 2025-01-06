package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

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
    @OneToMany(cascade = ALL)
    private List<SpotifyWrap> artists;
    @OneToMany(cascade = ALL)
    private List<SpotifyWrap> producers;
    @OneToMany(cascade = ALL)
    private List<SpotifyWrap> labels;
    @OneToMany(cascade = ALL)
    private List<SpotifyWrap> songWriters;
    private String releaseDate;
}
