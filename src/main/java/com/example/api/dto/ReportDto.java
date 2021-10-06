package com.example.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReportDto {
    @JsonProperty("report_id")
    private Long reportId;
    @JsonProperty("query_criteria_character_phrase")
    private String queryCriteriaCharacterPhrase;
    @JsonProperty("query_criteria_planet_name")
    private String queryCriteriaPlanetName;
    @JsonProperty("result")
    private List<ReportDataDTo> results;
}
