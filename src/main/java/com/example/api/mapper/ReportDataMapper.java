package com.example.api.mapper;

import com.example.api.dto.ReportDataDTo;
import com.example.api.entities.ReportData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportDataMapper {
    public ReportData map(ReportDataDTo reportDataDTo){
       return ReportData.builder()
                .filmId(reportDataDTo.getFilmId())
                .filmName(reportDataDTo.getFilmName())
                .CharacterId(reportDataDTo.getCharacterId())
                .CharacterName(reportDataDTo.getCharacterName())
                .planetId(reportDataDTo.getPlanetId())
                .planetName(reportDataDTo.getPlanetName())
                .build();
    }
    public ReportDataDTo map(ReportData reportData){
        return ReportDataDTo.builder()
                .filmId(reportData.getFilmId())
                .filmName(reportData.getFilmName())
                .CharacterId(reportData.getCharacterId())
                .CharacterName(reportData.getCharacterName())
                .planetId(reportData.getPlanetId())
                .planetName(reportData.getPlanetName())
                .build();
    }
    public List<ReportDataDTo> map(List<ReportData>reportDataList){
        return reportDataList.stream().map(this::map).collect(Collectors.toList());
    }
}
