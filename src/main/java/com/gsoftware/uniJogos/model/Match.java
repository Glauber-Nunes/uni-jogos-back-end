package com.gsoftware.uniJogos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Team homeTeam;
    @ManyToOne
    private Team awayTeam;
    private int homeGoals = -1; // Valor padrão para indicar gols não definidos
    private int awayGoals = -1; // Valor padrão para indicar gols não definidos
    private LocalDateTime dateTime; // Atualizado para armazenar data e hora
    private String groupName; // Novo campo para o grupo
    private String status; // status da partida
}
