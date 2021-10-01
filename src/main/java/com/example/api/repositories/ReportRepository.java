package com.example.api.repositories;

import com.example.api.entities.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReportRepository extends CrudRepository <Report, Long>{
    @Query(value = "select * from REPORT where queryCriteriaCharacterPhrase=CHARACTER_PHRASE ")
    Optional<Report> findByQueryCriteriaCharacterPhrase();
    @Query("select * from REPORT where queryCriteriaPlanetName=PLANET_NAME ")
    Optional<Report>findByQueryCriteriaPlanetName();

}
