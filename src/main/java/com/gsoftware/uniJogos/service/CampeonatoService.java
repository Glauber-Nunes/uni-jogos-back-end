package com.gsoftware.uniJogos.service;

import com.gsoftware.uniJogos.controller.v1.campeonato.dto.CampeonatoDTO;
import com.gsoftware.uniJogos.controller.v1.equipe.EquipeDTO;
import com.gsoftware.uniJogos.controller.v1.equipegrupodto.EquipeGrupoDTO;
import com.gsoftware.uniJogos.controller.v1.grupo.dto.GrupoDTO;
import com.gsoftware.uniJogos.model.Campeonato;
import com.gsoftware.uniJogos.model.EquipeGrupo;
import com.gsoftware.uniJogos.model.Grupo;
import com.gsoftware.uniJogos.repository.CampeonatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepository;

    public CampeonatoDTO criarCampeonato(Campeonato campeonato) {
        Campeonato savedCampeonato = campeonatoRepository.save(campeonato);
        return toDto(savedCampeonato);
    }

    public List<CampeonatoDTO> listarCampeonatos() {
        return campeonatoRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private CampeonatoDTO toDto(Campeonato campeonato) {
        return new CampeonatoDTO(
                campeonato.getId(),
                campeonato.getNome(),
                campeonato.getGrupos().stream().map(this::toDto).collect(Collectors.toList())
        );
    }

    private GrupoDTO toDto(Grupo grupo) {
        return new GrupoDTO(
                grupo.getId(),
                grupo.getNome(),
                grupo.getEquipes().stream().map(this::toDto).collect(Collectors.toList())
        );
    }

    private EquipeGrupoDTO toDto(EquipeGrupo equipeGrupo) {
        return new EquipeGrupoDTO(
                equipeGrupo.getId(),
                new EquipeDTO(equipeGrupo.getEquipe().getId(), equipeGrupo.getEquipe().getNome(), equipeGrupo.getEquipe().getEsporte(), equipeGrupo.getEquipe().getGenero()),
                equipeGrupo.getVitorias(),
                equipeGrupo.getEmpates(),
                equipeGrupo.getDerrotas(),
                equipeGrupo.getPontos()
        );
    }
}
