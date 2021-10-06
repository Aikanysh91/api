package com.example.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReportDataDTo {
    @JsonProperty("film_id")
    private Long filmId;
    @JsonProperty("film_name")
    private String filmName;
    @JsonProperty("character_id")
    private Long CharacterId;
    @JsonProperty("character_name")
    private String CharacterName;
    @JsonProperty("planet_id")
    private Long planetId;
    @JsonProperty("planet_id")
    private String planetName;
}
