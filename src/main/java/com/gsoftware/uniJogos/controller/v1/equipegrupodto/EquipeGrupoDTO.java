package com.gsoftware.uniJogos.controller.v1.equipegrupodto;

import com.gsoftware.uniJogos.controller.v1.equipe.EquipeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipeGrupoDTO {

    private Long id;
    private EquipeDTO equipe;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;
}
