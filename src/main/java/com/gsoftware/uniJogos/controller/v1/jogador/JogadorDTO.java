package com.gsoftware.uniJogos.controller.v1.jogador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorDTO {

    private Long id;
    private String nome;
    private String posicao;
}
