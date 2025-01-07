package com.biokes.apiBank.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
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
        @Id
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("name")
        private String name;
        @JsonProperty("shareUrl")
        private String previewUrl;
        @JsonProperty("explicit")
        private boolean explicit;
        @JsonProperty( "durationMs")
        private int durationMs;
        @JsonProperty("durationText")
        private String durationText;
        @JsonProperty("discNumber")
        private int discNumber;
        @JsonProperty("trackNumber")
        private int trackNumber;
        @JsonProperty("playCount")
        private long playCount;
        @JsonProperty("artists")
        @ManyToMany(cascade = ALL)
        @JoinTable(
                name = "album_artist",
                joinColumns = @JoinColumn(name = "album_id"),
                inverseJoinColumns = @JoinColumn(name = "artist_id")
        )
        private List<Artist> artists;
        @JsonProperty("is_local")
        private boolean isLocal;
        private String albumId;
}
//        @JsonProperty("available_markets")
//        @ElementCollection
//        private List<String> available_markets;
//        @ManyToOne
//        @JsonProperty("external_urls")
//        @JoinColumn(name = "externalUrls_id")
//        private ExternalUrls externalUrls;
//        private boolean isPlayable;