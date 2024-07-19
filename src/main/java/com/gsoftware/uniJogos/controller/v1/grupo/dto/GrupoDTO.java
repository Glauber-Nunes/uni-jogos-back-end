package com.gsoftware.uniJogos.controller.v1.grupo.dto;


import com.gsoftware.uniJogos.controller.v1.equipegrupodto.EquipeGrupoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoDTO {

    private Long id;
    private String nome;
    private List<EquipeGrupoDTO> equipes = new ArrayList<>();
}
