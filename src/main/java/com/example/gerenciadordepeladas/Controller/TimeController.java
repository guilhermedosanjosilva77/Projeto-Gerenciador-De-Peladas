package com.example.gerenciadordepeladas.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordepeladas.Entity.TimeEntity;
import com.example.gerenciadordepeladas.Service.TImeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/time")
public class TimeController {

    private final TImeService tImeService;

    public TimeController(TImeService tImeService) {
        this.tImeService = tImeService;
    }

    //CREATE
    @PostMapping
    public TimeEntity criar(@RequestBody TimeEntity timeEntity) {
        return tImeService.criar(timeEntity);
    }

    //READ
    @GetMapping
    public List<TimeEntity>listar() {
        return tImeService.listar();
    }

    //READ BY ID
    @GetMapping("{id_time}")
    public TimeEntity listarPorId(@PathVariable Long id_time) {
        return tImeService.listarPorId(id_time);
    }

    //UPDATE
    @PutMapping("/{id_time}")
    public TimeEntity atualizar(@PathVariable Long id_time, @RequestBody TimeEntity timeEntity) {
        
        return tImeService.atualizar(id_time, timeEntity);
    }

    //DELETE
    @DeleteMapping("/{id_time}")
    public void deletar(@PathVariable Long id_time){
        tImeService.deletar(id_time);
    }
    
    
    
    
}
