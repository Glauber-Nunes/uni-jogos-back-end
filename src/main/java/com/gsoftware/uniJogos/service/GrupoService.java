package com.gsoftware.uniJogos.service;

import com.gsoftware.uniJogos.controller.v1.equipe.EquipeDTO;
import com.gsoftware.uniJogos.controller.v1.equipegrupodto.EquipeGrupoDTO;
import com.gsoftware.uniJogos.controller.v1.grupo.dto.GrupoDTO;
import com.gsoftware.uniJogos.model.Equipe;
import com.gsoftware.uniJogos.model.Grupo;
import com.gsoftware.uniJogos.repository.EquipeRepository;
import com.gsoftware.uniJogos.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;
    private final EquipeRepository equipeRepository;

    private static final Logger logger = LoggerFactory.getLogger(GrupoService.class);

    public GrupoDTO adicionarEquipeAoGrupo(Long grupoId, Long equipeId) {

        Grupo grupo = grupoRepository.findById(grupoId).orElseThrow(() -> new RuntimeException("TODO"));
        Equipe equipe = equipeRepository.findById(equipeId).orElseThrow(() -> new RuntimeException("TODO"));
        grupo.adicionarEquipe(equipe);
        grupo = grupoRepository.save(grupo);
        return new GrupoDTO(grupo.getId(), grupo.getNome(), grupo.getEquipes().stream()
                .map(equipeGrupo -> new EquipeGrupoDTO(equipeGrupo.getId(),
                        new EquipeDTO(equipeGrupo.getEquipe().getId(), equipeGrupo.getEquipe().getNome(),
                                equipeGrupo.getEquipe().getEsporte(), equipeGrupo.getEquipe().getGenero()),
                        equipeGrupo.getVitorias(), equipeGrupo.getEmpates(), equipeGrupo.getDerrotas(),
                        equipeGrupo.getPontos())).collect(Collectors.toList()));
    }

    public GrupoDTO obterGrupoPorId(Long grupoId) {
        logger.info("Buscando grupo com ID: {}", grupoId);
        Optional<Grupo> grupoOpt = grupoRepository.findById(grupoId);
        if (grupoOpt.isPresent()) {
            Grupo grupo = grupoOpt.get();
            logger.info("Grupo encontrado: {}", grupo.getNome());
            return new GrupoDTO(grupo.getId(), grupo.getNome(), grupo.getEquipes().stream()
                    .map(equipeGrupo -> new EquipeGrupoDTO(
                            equipeGrupo.getId(),
                            new EquipeDTO(
                                    equipeGrupo.getEquipe().getId(),
                                    equipeGrupo.getEquipe().getNome(),
                                    equipeGrupo.getEquipe().getEsporte(),
                                    equipeGrupo.getEquipe().getGenero()),
                            equipeGrupo.getVitorias(),
                            equipeGrupo.getEmpates(),
                            equipeGrupo.getDerrotas(),
                            equipeGrupo.getPontos()))
                    .collect(Collectors.toList()));
        } else {
            logger.error("Grupo não encontrado com ID: {}", grupoId);
            throw new RuntimeException("Grupo não encontrado com ID: " + grupoId);
        }

    }
}
