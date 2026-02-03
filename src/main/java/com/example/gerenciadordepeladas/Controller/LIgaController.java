package com.example.gerenciadordepeladas.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordepeladas.Entity.LigaEntity;
import com.example.gerenciadordepeladas.Service.LigaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/liga")
public class LIgaController {

    private final LigaService ligaService;

    public LIgaController(LigaService ligaService) {
        this.ligaService = ligaService;
    }

    //CREATE
    @PostMapping
    public LigaEntity criar(@RequestBody LigaEntity ligaEntity) {
        return ligaService.criar(ligaEntity);
        
    }

    //READ
    @GetMapping
    public List<LigaEntity> ler() {
        return ligaService.listarLiga();
    }

    //READ BY ID
    @GetMapping("/{id_liga}")
    public LigaEntity lerPorId(@PathVariable Long id_liga){
        return ligaService.listarPorId(id_liga);

    }

    //UPDATE
    @PutMapping("/{id_liga}")
    public LigaEntity atualizar (@PathVariable Long id_liga, @RequestBody LigaEntity ligaEntity) {
        //TODO: process PUT request
        
        return ligaService.atualizar(ligaEntity, id_liga);
    }

    //DELETE
    @DeleteMapping("/{id_liga}")
    public void deletar(@PathVariable Long id_liga){
        ligaService.deletar(id_liga);
    }

    //COMENTARIOS SOBRE O CÓDIGO
    //PATH VARIABLE USADO QUANDO O METODO PRECISA DE UM ID
    //E REQUEST BODY QUANDO PRECISAR APONTAR OUTRA CLASSE
    
    
    
}
