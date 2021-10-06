package com.example.api.services;

import com.example.api.dto.QueryDto;
import com.example.api.dto.ReportDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportCreate {
    public ReportDto createReport(Long id, QueryDto queryDto){
        return ReportDto.builder()
                .reportId(id)
                .queryCriteriaCharacterPhrase(queryDto.getQueryCriteriaCharacterPhrase())
                .queryCriteriaPlanetName(queryDto.getQueryCriteriaPlanetName())
                .results(List.of())
                .build();



    }
}
