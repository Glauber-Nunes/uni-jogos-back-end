package com.gsoftware.uniJogos.controller.v1.campeonato;

import com.gsoftware.uniJogos.controller.v1.campeonato.dto.CampeonatoDTO;
import com.gsoftware.uniJogos.model.Campeonato;
import com.gsoftware.uniJogos.service.CampeonatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campeonatos")
@RequiredArgsConstructor
public class CampeonatoController {

    private final CampeonatoService campeonatoService;

    @PostMapping
    public CampeonatoDTO criarCampeonato(@RequestBody Campeonato campeonato) {
        return campeonatoService.criarCampeonato(campeonato);
    }

    @GetMapping
    public List<CampeonatoDTO> listarCampeonatos() {
        return campeonatoService.listarCampeonatos();
    }
}
