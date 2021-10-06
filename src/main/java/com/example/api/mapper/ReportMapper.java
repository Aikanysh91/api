package com.example.api.mapper;

import com.example.api.dto.ReportDto;
import com.example.api.entities.Report;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapper {
    public ReportDto map(Report report){
        return ReportDto.builder()
                .reportId(report.getReportId())
                .queryCriteriaCharacterPhrase(report.getQueryCriteriaCharacterPhrase())
                .queryCriteriaPlanetName(report.getQueryCriteriaPlanetName())
                .build();
    }

    public List<ReportDto> map (List<Report> reports){
        return reports.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
    public Report map (ReportDto reportDto){
        return Report.builder()
                .reportId(reportDto.getReportId())
                .queryCriteriaCharacterPhrase(reportDto.getQueryCriteriaCharacterPhrase())
                .queryCriteriaPlanetName(reportDto.getQueryCriteriaPlanetName())
                .build();
    }
}
