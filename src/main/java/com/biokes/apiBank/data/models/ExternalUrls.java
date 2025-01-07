package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="externalUrls")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalUrls {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String spotify;
}
