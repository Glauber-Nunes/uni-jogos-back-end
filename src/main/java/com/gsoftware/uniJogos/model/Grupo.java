package com.gsoftware.uniJogos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_name")
    @SequenceGenerator(name = "sequence_name", sequenceName = "your_sequence", allocationSize = 1)
    private Long id;


    private String nome;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EquipeGrupo> equipes = new ArrayList<>();

    public void adicionarEquipe(Equipe equipe) {
        EquipeGrupo equipeGrupo = new EquipeGrupo();
        equipeGrupo.setGrupo(this);
        equipeGrupo.setEquipe(equipe);
        equipes.add(equipeGrupo);
    }
}
