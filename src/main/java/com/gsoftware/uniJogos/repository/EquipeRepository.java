package com.gsoftware.uniJogos.repository;

import com.gsoftware.uniJogos.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {

    List<Equipe> findByEsporteAndGenero(String esporte, String genero);
}
