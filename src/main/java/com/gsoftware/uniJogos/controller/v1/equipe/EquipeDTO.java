package com.gsoftware.uniJogos.controller.v1.equipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipeDTO {
    private Long id;
    private String nome;
    private String esporte;
    private String genero;
}
