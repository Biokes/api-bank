package com.biokes.apiBank.data.models;


import jakarta.persistence.Embeddable;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Embeddable
public class Artist {
    private String name;
    private String spotifyUri;
    private String externalUri;
}
