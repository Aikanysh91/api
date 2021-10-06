package com.example.api.repositories;

import com.example.api.entities.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface ReportRepository extends CrudRepository <Report, Long>{

    @Query("FROM REPORT WHERE queryCriteriaCharacterPhrase='CHARACTER_PHRASE' and queryCriteriaPlanetName='PLANET_NAME'")
    List<Report>findAllByQueryCriteriaCharacterPhraseAndQueryCriteriaPlanetName();


}
