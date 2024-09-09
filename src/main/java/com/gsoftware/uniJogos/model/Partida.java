package com.gsoftware.uniJogos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_name")
    @SequenceGenerator(name = "sequence_name", sequenceName = "your_sequence", allocationSize = 1)
    private Long id;


    private LocalDateTime dataHora;
    private String localizacao;

    @ManyToOne
    private Equipe equipe1;

    @ManyToOne
    private Equipe equipe2;

    private String status; // AGENDADA, EM_ANDAMENTO, FINALIZADA

    @OneToMany(mappedBy = "partida")
    private List<EventoPartida> eventos = new ArrayList<>();
}
