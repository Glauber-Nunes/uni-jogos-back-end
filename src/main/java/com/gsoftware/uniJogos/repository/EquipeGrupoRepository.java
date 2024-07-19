package com.gsoftware.uniJogos.repository;

import com.gsoftware.uniJogos.model.Equipe;
import com.gsoftware.uniJogos.model.EquipeGrupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeGrupoRepository extends JpaRepository<EquipeGrupo,Long> {
    EquipeGrupo findByEquipe(Equipe equipe);
}
