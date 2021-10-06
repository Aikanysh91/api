package com.example.api.services;

import com.example.api.dto.QueryDto;
import com.example.api.dto.ReportDto;
import com.example.api.entities.ReportData;
import com.example.api.mapper.ReportMapper;
import com.example.api.repositories.ReportRepository;
import com.example.api.entities.Report;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportService {

    private ReportRepository reportRepository;
    private ReportMapper mapper;
    @Autowired
    public ReportService(ReportRepository reportRepository, ReportMapper mapper) {
        this.reportRepository = reportRepository;
        this.mapper = mapper;
    }

    private ReportCreate reportCreate;

     public void createUpdateReport(Long id, QueryDto queryDto) {
         if (this.reportRepository.findById(id).isEmpty()) {
             ReportDto reportDto=reportCreate.createReport(id, queryDto);
             Report report=this.mapper.map(reportDto);
             this.reportRepository.save(report);


         } else {
             Report report1 = this.reportRepository.findById(id).get();
             report1.setReportId(report1.getReportId());
             report1.setQueryCriteriaCharacterPhrase("CHARACTER_PHRASE");
             report1.setQueryCriteriaPlanetName("PLANET_NAME");

             this.reportRepository.save(report1);
             this.mapper.map(report1);
         }
     }
     public void removeReport(Long id){
          this.reportRepository.findById(id)
                  .orElseThrow(()->new IllegalArgumentException("Report with this id"+id+"does not exists!"));

          this.reportRepository.deleteById(id);
     }
     public void removeAllReports(){
         this.reportRepository.deleteAll();
     }
     public List<ReportDto>getAllReports(){
         List<Report>reports=new ArrayList<>();
         this.reportRepository.findAllByQueryCriteriaCharacterPhraseAndQueryCriteriaPlanetName().forEach(reports::add);
         if(reports.isEmpty()){
             throw new IllegalArgumentException("There is no reports with this query in database");
         }
         return this.mapper.map(reports);
     }
     public ReportDto getReportById(Long id){
         Report report =this.reportRepository.findById(id).get();
         return this.mapper.map(report);
     }
}
