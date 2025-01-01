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
@Table
class Artist {
    @Id
    @Column(nullable = false, unique = true)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String uri;
    @Embedded
    private ExternalUrls externalUrls;
}