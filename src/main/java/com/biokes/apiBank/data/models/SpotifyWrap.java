package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotifyWrap {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String spotifyUri;
    private String externalUrl;
}
