package com.example.provaAv1.controller;

import com.example.provaAv1.service.NoticiaService;
import com.example.provaAv1.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
