package com.gsoftware.uniJogos.controller.v1.partida;

import com.gsoftware.uniJogos.model.Partida;
import com.gsoftware.uniJogos.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/partidas")
public class PartidaController {

    private final PartidaService partidaService;

    @PostMapping
    public Partida agendarPartida(@RequestBody Partida partida) {
        return partidaService.agendarPartida(partida);
    }

    @GetMapping
    public List<PartidaDTO> listarPartidas() {
        return partidaService.listarPartidas();
    }

    @PostMapping("/{partidaId}/resultado")
    public void atualizarResultado(
            @PathVariable Long partidaId,
            @RequestParam int golsEquipe1,
            @RequestParam int golsEquipe2) {
        partidaService.atualizarResultado(partidaId, golsEquipe1, golsEquipe2);
    }
}
