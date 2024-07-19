package com.gsoftware.uniJogos.controller.v1.campeonato.dto;

import com.gsoftware.uniJogos.controller.v1.grupo.dto.GrupoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampeonatoDTO {

    private Long id;
    private String nome;
    private List<GrupoDTO> grupos = new ArrayList<>();
}
