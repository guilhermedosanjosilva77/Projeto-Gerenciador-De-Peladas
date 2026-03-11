package com.example.gerenciadordepeladas.Controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordepeladas.DTO.EstatisticaJogadorRequest;
import com.example.gerenciadordepeladas.DTO.EstatisticaJogadorResponse;
import com.example.gerenciadordepeladas.Service.Estatistica_JogadorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/statsJogador")
public class EstatisticaJogadorController {

    private final Estatistica_JogadorService estatistica_Jogador;

    public EstatisticaJogadorController(Estatistica_JogadorService estatistica_Jogador) {
        this.estatistica_Jogador = estatistica_Jogador;
    }

    //POST
    @PostMapping
    public EstatisticaJogadorResponse criar(@RequestBody EstatisticaJogadorRequest estatisticaRequest) {
        
        return estatistica_Jogador.criar(estatisticaRequest);
    }

    //GET
    @GetMapping
    public List<EstatisticaJogadorResponse>listar(){
        return estatistica_Jogador.listar();

    }
    
    //GET BY ID
    @GetMapping("/{id_estatistica_jogador}")
    public EstatisticaJogadorResponse listarPorId(@PathVariable Long id_estatistica_jogador) {
        return estatistica_Jogador.listarPorId(id_estatistica_jogador);
    }

    //PUT
    @PutMapping("/{id_estatistica_jogador}")
    public EstatisticaJogadorResponse atualizar(@PathVariable Long id_estatistica_jogador, @RequestBody EstatisticaJogadorRequest estatisticaRequest) {
        
        return estatistica_Jogador.atualizar(id_estatistica_jogador, estatisticaRequest);
    }

    @DeleteMapping("/{id_estatistica_jogador}")
    public void deletar(@PathVariable Long id_estatistica_jogador){
        estatistica_Jogador.deletar(id_estatistica_jogador);
    }
    
    
    

    
}