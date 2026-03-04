package com.example.gerenciadordepeladas.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordepeladas.DTO.JogadorRequest;
import com.example.gerenciadordepeladas.DTO.JogadorResponse;
import com.example.gerenciadordepeladas.Service.JogadorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/jogador")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    //POST
    @PostMapping
    public JogadorResponse criar(@RequestBody JogadorRequest jogadorRequest){
        
        return jogadorService.criar(jogadorRequest);
    }
    
    //GET
    @GetMapping
    public List<JogadorResponse> buscar() {
        return jogadorService.listarJogadores();
    }

    //GET BY ID
    @GetMapping("/{id_jogador}")
    public JogadorResponse buscarPorId( @PathVariable Long id_jogador) {
        return jogadorService.listarPorId(id_jogador);
    }

    //PUT
    @PutMapping("/{id_jogador}")
    public JogadorResponse atualizar(@PathVariable Long id_jogador, @RequestBody JogadorRequest jogadorRequest) {
        
        return jogadorService.atualizar(id_jogador, jogadorRequest);
    }

    //DELETE
   
    @DeleteMapping("/{id_jogador}")
    public void deletar(@PathVariable Long id_jogador){
        jogadorService.deletar(id_jogador);
    }
    
    
    
}
