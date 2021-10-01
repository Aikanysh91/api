package com.example.api.services;

import com.example.api.repositories.ReportRepository;
import com.example.api.entities.Report;
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
    @Autowired
     private ReportRepository reportRepository;

     public void createUpdateReport(Long id){
          if(this.reportRepository.findById(id).isEmpty()){
               Report report=new Report();
               this.reportRepository.save(report);

          }else{
              Report report1 = this.reportRepository.findById(id).get();
              report1.setReportId(report1.getReportId());
              report1.setQueryCriteriaCharacterPhrase(report1.getQueryCriteriaCharacterPhrase());
              report1.setQueryCriteriaPlanetName(report1.getQueryCriteriaPlanetName());

              this.reportRepository.save(report1);
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
     public List<Report>getAllReports(){
         List<Report>reports=new ArrayList<>();
         this.reportRepository.findAll().forEach(reports::add);
         if(reports.isEmpty()){
             throw new IllegalArgumentException("There is no reports in database");
         }
         return reports;
     }
     public Report getReportById(Long id){
         Report report =this.reportRepository.findById(id).get();
         return report;
     }
}
