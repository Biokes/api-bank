package com.biokes.apiBank.data.models;

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
public class ExternalUrls {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String spotify;
}
