package com.gsoftware.uniJogos.controller.v1.grupo;

import com.gsoftware.uniJogos.controller.v1.grupo.dto.GrupoDTO;
import com.gsoftware.uniJogos.service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    @PostMapping("/{grupoId}/adicionarEquipe")
    public GrupoDTO adicionarEquipe(@PathVariable Long grupoId, @RequestParam Long equipeId) {
        return grupoService.adicionarEquipeAoGrupo(grupoId, equipeId);
    }

    @GetMapping("/{grupoId}")
    public GrupoDTO obterGrupoPorId(@PathVariable Long grupoId) {
        return grupoService.obterGrupoPorId(grupoId);
    }
}
