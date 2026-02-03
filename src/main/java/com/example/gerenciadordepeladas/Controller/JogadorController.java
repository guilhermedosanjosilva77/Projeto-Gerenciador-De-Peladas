package com.example.gerenciadordepeladas.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordepeladas.Entity.JogadorEntity;
import com.example.gerenciadordepeladas.Service.JogadorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




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

    //READ
    @GetMapping
    public List<JogadorEntity>listar() {
        return jogadorService.listarJogadores();
    }

    //READ BY ID
    @GetMapping("{id_jogador}")
    public JogadorEntity listarporid(@PathVariable Long id_jogador) {
        return jogadorService.listarPorId(id_jogador) ;
    }

    //UPDATE
    @PutMapping("/{id_jogador}")
    public JogadorEntity atualizar(@PathVariable Long id_jogador, @RequestBody JogadorEntity jogadorEntity) {
        
        return jogadorService.atualizar(id_jogador, jogadorEntity);
    }

    //DELETE
    @DeleteMapping("/{id_jogador}")
    public void deletar(@PathVariable Long id_jogador){
        jogadorService.deletar(id_jogador);

    }
    
    
    
    
}
