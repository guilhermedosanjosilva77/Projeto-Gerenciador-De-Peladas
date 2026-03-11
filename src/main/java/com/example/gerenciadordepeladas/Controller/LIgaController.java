package com.example.gerenciadordepeladas.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordepeladas.DTO.LigaRequest;
import com.example.gerenciadordepeladas.DTO.LigaResponse;
import com.example.gerenciadordepeladas.Service.LigaService;

import jakarta.validation.Valid;

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
    public LigaResponse criar(@Valid @RequestBody LigaRequest ligaRequest) {
        return ligaService.criar(ligaRequest);
        
    }

    //READ
    @GetMapping
    public List<LigaResponse> listar() {
        return ligaService.listar();
    }

    //READ BY ID
    @GetMapping("/{id_liga}")
    public LigaResponse listarPorId(@PathVariable Long id_liga){
        return ligaService.listarPorId(id_liga);

    }

    //UPDATE
    @PutMapping("/{id_liga}")
    public LigaResponse atualizar (@PathVariable Long id_liga, @Valid @RequestBody LigaRequest ligaRequest) {
        //TODO: process PUT request
        
        return ligaService.atualizar(id_liga, ligaRequest);
    }

    //DELETE
    @DeleteMapping("/{id_liga}")
    public void deletar(@PathVariable Long id_liga){
        ligaService.deletar(id_liga);
    }
    
    
    
}
