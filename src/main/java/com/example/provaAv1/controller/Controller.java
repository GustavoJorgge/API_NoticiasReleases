package com.example.provaAv1.controller;

import com.example.provaAv1.model.NoticiaEntity;
import com.example.provaAv1.model.ReleaseEntity;
import com.example.provaAv1.service.NoticiaService;
import com.example.provaAv1.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/noticias")
public class Controller {

    @Autowired
    private NoticiaService noticiaService;
    @Autowired
    private ReleaseService releaseService;
    @GetMapping()
    public String BuscaNoticias(){
        return noticiaService.buscaNoticia();
    }

    @GetMapping("/releases")
    public String BuscaReleases(){
        return releaseService.buscaRelease();
    }

    @GetMapping("/noticiasreleases")
    public String BuscaNoticiaReleases(){
        return noticiaService.buscaNoticiaRelease();
    }

    @PostMapping ("/releases")
    public ReleaseEntity inserir(@RequestBody ReleaseEntity release){
        return releaseService.insereir(release);
    }

    @PostMapping ("/noticias")
    public NoticiaEntity inserir(@RequestBody NoticiaEntity noticia){
        return noticiaService.insereir(noticia);
    }


}
