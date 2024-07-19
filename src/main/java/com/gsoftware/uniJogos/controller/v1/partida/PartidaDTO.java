package com.gsoftware.uniJogos.controller.v1.partida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDTO {

    private Long id;
    private LocalDateTime dataHora;
    private String localizacao;
    private String equipe1Nome;
    private String equipe2Nome;
    private String status; // AGENDADA, EM_ANDAMENTO, FINALIZADA
}
