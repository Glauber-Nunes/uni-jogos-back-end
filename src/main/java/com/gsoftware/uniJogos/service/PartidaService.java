package com.gsoftware.uniJogos.service;

import com.gsoftware.uniJogos.controller.v1.partida.PartidaDTO;
import com.gsoftware.uniJogos.model.EquipeGrupo;
import com.gsoftware.uniJogos.model.Partida;
import com.gsoftware.uniJogos.repository.EquipeGrupoRepository;
import com.gsoftware.uniJogos.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartidaService {

    private final PartidaRepository partidaRepository;

    private final EquipeGrupoRepository equipeGrupoRepository;

    public Partida agendarPartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public List<PartidaDTO> listarPartidas() {
        return partidaRepository.findAll().stream()
                .map(partida -> new PartidaDTO(partida.getId(), partida.getDataHora(), partida.getLocalizacao(),
                        partida.getEquipe1().getNome(), partida.getEquipe2().getNome(),partida.getStatus()))
                .collect(Collectors.toList());
    }

    public void atualizarResultado(Long partidaId, int golsEquipe1, int golsEquipe2) {
        Partida partida = partidaRepository.findById(partidaId).orElseThrow();
        EquipeGrupo equipeGrupo1 = equipeGrupoRepository.findByEquipe(partida.getEquipe1());
        EquipeGrupo equipeGrupo2 = equipeGrupoRepository.findByEquipe(partida.getEquipe2());

        if (golsEquipe1 > golsEquipe2) {
            equipeGrupo1.setVitorias(equipeGrupo1.getVitorias() + 1);
            equipeGrupo1.setPontos(equipeGrupo1.getPontos() + 3);
            equipeGrupo2.setDerrotas(equipeGrupo2.getDerrotas() + 1);
        } else if (golsEquipe1 < golsEquipe2) {
            equipeGrupo2.setVitorias(equipeGrupo2.getVitorias() + 1);
            equipeGrupo2.setPontos(equipeGrupo2.getPontos() + 3);
            equipeGrupo1.setDerrotas(equipeGrupo1.getDerrotas() + 1);
        } else {
            equipeGrupo1.setEmpates(equipeGrupo1.getEmpates() + 1);
            equipeGrupo2.setEmpates(equipeGrupo2.getEmpates() + 1);
            equipeGrupo1.setPontos(equipeGrupo1.getPontos() + 1);
            equipeGrupo2.setPontos(equipeGrupo2.getPontos() + 1);
        }

        equipeGrupoRepository.save(equipeGrupo1);
        equipeGrupoRepository.save(equipeGrupo2);
    }
}
