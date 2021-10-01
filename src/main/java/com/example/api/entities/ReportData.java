package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="REPORT_DATA")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id")
    private Long filmId;
    @Column(name="film_name")
    private String filmName;
    @Column(name="character_id")
    private Long CharacterId;
    @Column(name="character_name")
    private String CharacterName;
    @Column(name="planet_id")
    private Long planetId;
    @Column(name="planet_id")
    private String planetName;
}
