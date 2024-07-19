package com.gsoftware.uniJogos.service;

import com.gsoftware.uniJogos.controller.v1.equipe.EquipeDTO;
import com.gsoftware.uniJogos.model.Equipe;
import com.gsoftware.uniJogos.model.Jogador;
import com.gsoftware.uniJogos.repository.EquipeRepository;
import com.gsoftware.uniJogos.repository.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EquipeService {

    private final EquipeRepository equipeRepository;

    private final JogadorRepository jogadorRepository;

    public Equipe criarEquipe(Equipe equipe) {
        if (equipe.getJogadores().size() > 10) {
            throw new RuntimeException("A equipe não pode ter mais de 10 jogadores.");
        }
        return equipeRepository.save(equipe);
    }

    public List<EquipeDTO> listarEquipesCriteria(String esporte, String genero) {
        return equipeRepository.findByEsporteAndGenero(esporte, genero).stream()
                .map(equipe -> new EquipeDTO(equipe.getId(), equipe.getNome(), equipe.getEsporte(), equipe.getGenero()))
                .collect(Collectors.toList());
    }

    public Jogador adicionarJogador(Long equipeId, Jogador jogador) {

        Equipe equipe = equipeRepository.findById(equipeId)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        if (equipe.getJogadores().size() >= 10) {
            throw new RuntimeException("A equipe não pode ter mais de 10 jogadores.");
        }

        jogador.setEquipe(equipe);
        return jogadorRepository.save(jogador);
    }

    public List<EquipeDTO> listarEquipes() {
        return equipeRepository.findAll().stream()
                .map(equipe -> new EquipeDTO(equipe.getId(), equipe.getNome(), equipe.getEsporte(), equipe.getGenero()))
                .collect(Collectors.toList());
    }
}
