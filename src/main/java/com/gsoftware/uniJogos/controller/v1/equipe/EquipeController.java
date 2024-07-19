package com.gsoftware.uniJogos.controller.v1.equipe;

import com.gsoftware.uniJogos.model.Equipe;
import com.gsoftware.uniJogos.model.Jogador;
import com.gsoftware.uniJogos.service.EquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/equipes")
public class EquipeController {

    private final EquipeService equipeService;

    @PostMapping
    public Equipe criarEquipe(@RequestBody Equipe equipe) {
        return equipeService.criarEquipe(equipe);
    }

    @GetMapping("/lista-criteria")
    public List<EquipeDTO> listarEquipesPorCriteria(@RequestParam String esporte, @RequestParam String genero) {
        return equipeService.listarEquipesCriteria(esporte, genero);
    }

    @PostMapping("/{equipeId}/jogadores")
    public Jogador adicionarJogador(@PathVariable Long equipeId, @RequestBody Jogador jogador) {
        return equipeService.adicionarJogador(equipeId, jogador);
    }

    @GetMapping
    public List<EquipeDTO> listarEquipes() {
        return equipeService.listarEquipes();
    }
}
