package com.biokes.apiBank.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Track {
        @Id
        @Column(nullable = false, unique = true)
        private String id;
        @Column(nullable = false)
        private String name;
        private int discNumber;
        private int durationMs;
        private boolean explicit;
        private boolean isPlayable;
        @Column(nullable = true)
        private String previewUrl;
        private int trackNumber;
        private boolean isLocal;
        @Embedded
        private ExternalUrls externalUrls;
        @Column(nullable = false)
        private String type;
        @Column(nullable = false)
        private String uri;
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "track_id")
        private List<Artist> artists;
        private boolean isGlobalData;

}
