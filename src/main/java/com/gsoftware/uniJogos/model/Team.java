package com.gsoftware.uniJogos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int points = 0;
    private int wins =0;
    private int draws =0;
    private int losses =0;
    private int goalsFor =0;
    private int goalsAgainst = 0;
    private String groupName; // grupo
    private int gamesPlayed =0; // quantidade de jogos
}
