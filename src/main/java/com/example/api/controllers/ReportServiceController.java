package com.example.api.controllers;

import com.example.api.dto.QueryDto;
import com.example.api.dto.ReportDto;
import com.example.api.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("report")
public class ReportServiceController {

    private ReportService reportService;
    @Autowired
    public ReportServiceController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PutMapping("/{report_id}")
    public ResponseEntity<ReportDto> generates(@PathVariable("report_id") Long id,
                                               @RequestBody QueryDto queryDto){
        reportService.createUpdateReport(id,queryDto);
        return ResponseEntity.status(204).build();
    }
    @DeleteMapping("/{report_id}")
    public void delete(@PathVariable("report_id") Long id){
        reportService.removeReport(id);
    }
    @DeleteMapping
    public void deleteAll(){
        reportService.removeAllReports();
    }
    @GetMapping
    public List<ReportDto> getAll(){
        return reportService.getAllReports();
    }
    @GetMapping("/{report_id}")
    public ReportDto getByReportId(@PathVariable("report_id") Long id){
        return reportService.getReportById(id);
    }

}
