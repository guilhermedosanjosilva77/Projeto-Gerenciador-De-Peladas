package com.example.gerenciadordepeladas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordepeladas.Entity.JogadorEntity;
import com.example.gerenciadordepeladas.Service.JogadorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    //CREATE
    @PostMapping
    public JogadorEntity criar(@RequestBody JogadorEntity jogadorEntity) {
        //TODO: process POST request
        
        return jogadorService.criar(jogadorEntity);
    }
    
    
}
