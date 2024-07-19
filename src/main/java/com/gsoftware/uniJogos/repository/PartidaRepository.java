package com.gsoftware.uniJogos.repository;

import com.gsoftware.uniJogos.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida,Long> {
    List<Partida> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}
