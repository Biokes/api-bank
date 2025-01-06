package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {
        @JsonProperty("artists")
        @OneToMany(cascade = CascadeType.ALL)
        private List<Artist> artists;
        @JsonProperty("available_markets")
        @ElementCollection
        private List<String> available_markets;
        @JsonProperty("disc_number")
        private int discNumber;
        @JsonProperty( "duration_ms")
        private int durationMs;
        @JsonProperty("explicit")
        private boolean explicit;
        @ManyToOne
        @JsonProperty("external_urls")
        @JoinColumn(name = "externalUrls_id")
        private ExternalUrls externalUrls;
        @Id
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        private boolean isPlayable;
        @JsonProperty("preview_url")
        private String previewUrl;
        @JsonProperty("track_number")
        private int trackNumber;
        @JsonProperty("is_local")
        private boolean isLocal;
        @JsonProperty("type")
        private String type;
        private String uri;
}
