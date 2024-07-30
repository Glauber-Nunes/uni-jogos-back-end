package com.gsoftware.uniJogos.controller.v1.match.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MatchGenerationRequestDTO {

    private String groupName;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
