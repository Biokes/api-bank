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
        private String id;
        private String name;
        private int discNumber;
        private int durationMs;
        private boolean explicit;
        private boolean isPlayable;
        private String previewUrl;
        private int trackNumber;
        private boolean isLocal;
        @ManyToOne
        @JoinColumn(name = "externalUrls_id")
        private ExternalUrls externalUrls;
        private String type;
        private String uri;
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Artist> artists;
        private boolean isGlobalData;

}
