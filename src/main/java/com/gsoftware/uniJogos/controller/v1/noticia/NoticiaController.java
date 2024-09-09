package com.gsoftware.uniJogos.controller.v1.noticia;

import com.gsoftware.uniJogos.model.Noticia;
import com.gsoftware.uniJogos.service.NoticiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/noticias")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class NoticiaController {

    private final NoticiaService noticiaService;

    @PostMapping
    public Noticia criarNoticia(@RequestBody Noticia noticia) {
        return noticiaService.salvarNoticia(noticia);
    }

    @GetMapping
    public List<Noticia> listarNoticias() {
        return noticiaService.listarNoticias();
    }
}
