package com.biokes.apiBank.data.models;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Artist {
    @Id
    private String id;
    private String name;
    private String type;
    private String uri;
    @ManyToOne
    @JoinColumn(name = "externalUrls_id")
    private ExternalUrls externalUrls;
}