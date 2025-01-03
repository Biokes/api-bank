package com.biokes.apiBank.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExternalUrls {
    @Column(nullable = false)
    private String spotify;
}
