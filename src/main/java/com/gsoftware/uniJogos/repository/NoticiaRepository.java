package com.gsoftware.uniJogos.repository;

import com.gsoftware.uniJogos.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia,Long> {
}
