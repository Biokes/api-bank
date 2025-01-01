package com.biokes.apiBank.data.models;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Artist {
    private String name;
    private String spotifyUri;
    private String externalUri;
}
