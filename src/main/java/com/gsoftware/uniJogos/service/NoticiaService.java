package com.gsoftware.uniJogos.service;

import com.gsoftware.uniJogos.model.Noticia;
import com.gsoftware.uniJogos.repository.NoticiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticiaService {

    private final NoticiaRepository noticiaRepository;

    public Noticia salvarNoticia(Noticia noticia) {
        noticia.setDataPublicacao(LocalDate.now()); // Definir a data de publicação
        return noticiaRepository.save(noticia);
    }

    public List<Noticia> listarNoticias() {
        return noticiaRepository.findAll();
    }
}
