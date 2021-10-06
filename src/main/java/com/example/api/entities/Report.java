package com.example.api.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity(name="REPORT")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
    @Column
    private String queryCriteriaCharacterPhrase;
    @Column
    private String queryCriteriaPlanetName;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "result_id")
    private List<ReportData> results;
}
