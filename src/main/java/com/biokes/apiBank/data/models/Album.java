package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private String album_type;
    @Id
    @JsonProperty("id")
    private String spotifyId;
    @ElementCollection
    private List<String> available_markets;
    @OneToOne(cascade = ALL)
    @JoinColumn(name = "externalUrls_id")
    private ExternalUrls external_urls;
    @OneToMany(cascade = ALL)
    @JoinColumn(name = "images_id")
    private List<Image> images;
    private String name;
    private String release_date;
    private String release_date_precision;
    private int total_tracks;
    private String type;
    private String uri;

}