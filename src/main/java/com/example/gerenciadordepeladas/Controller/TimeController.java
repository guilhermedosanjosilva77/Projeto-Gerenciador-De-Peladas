package com.example.gerenciadordepeladas.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordepeladas.DTO.TimeRequest;
import com.example.gerenciadordepeladas.DTO.TimeResponse;
import com.example.gerenciadordepeladas.Service.TimeService;

@RestController
@RequestMapping("/time")
public class TimeController {

        private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    //CREATE
    @PostMapping
    public TimeResponse criar(@RequestBody TimeRequest timeRequest) {
        return timeService.criar(timeRequest);
        
    }

    //READ
    @GetMapping
    public List<TimeResponse> buscar() {
        return timeService.buscar();
    }

    //READ BY ID
    @GetMapping("/{id_time}")
    public TimeResponse lerPorId(@PathVariable Long id_time){
        return timeService.listarPorID(id_time);

    }

    //UPDATE
    @PutMapping("/{id_time}")
    public TimeResponse atualizar (@PathVariable Long id_time, @RequestBody TimeRequest timeRequest) {
        return timeService.atualizar(id_time, timeRequest);
    }

    //DELETE
    @DeleteMapping("/{id_time}")
    public void deletar(@PathVariable Long id_time){
        timeService.deletar(id_time);;
    }

    //COMENTARIOS SOBRE O CÓDIGO
    //PATH VARIABLE USADO QUANDO O METODO PRECISA DE UM ID
    //E REQUEST BODY QUANDO PRECISAR APONTAR OUTRA CLASSE
    
    
    
}
