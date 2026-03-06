package com.example.gerenciadordepeladas.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordepeladas.DTO.EstatisticaTimeRequest;
import com.example.gerenciadordepeladas.DTO.EstatisticaTimeResponse;
import com.example.gerenciadordepeladas.Service.Estatistica_TimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/statsTime")
public class EstatisticaTimeController {

    private final Estatistica_TimeService estatistica_time;

    public EstatisticaTimeController(Estatistica_TimeService estatistica_time) {
        this.estatistica_time = estatistica_time;
    }

    //POST
    @PostMapping
    public EstatisticaTimeResponse criar(@RequestBody EstatisticaTimeRequest estatisticaTimeRequest) {

        
        return estatistica_time.criar(estatisticaTimeRequest);
    }

    //GET
    @GetMapping
    public List<EstatisticaTimeResponse> listar() {
        return estatistica_time.listar();
    }

    //GET BY ID
    @GetMapping("/{id_estatistica_time}")
    public EstatisticaTimeResponse listarPorId(@PathVariable Long id_estatistica_time) {
        return estatistica_time.listarPorId(id_estatistica_time);
    }

    @PutMapping("/{id_estatistica_time}")
    public EstatisticaTimeResponse atualizar(@PathVariable Long id_estatistica_time, @RequestBody EstatisticaTimeRequest estatisticaTimeRequest ) {
        
        return estatistica_time.atualizar(id_estatistica_time, estatisticaTimeRequest);
    }

    @DeleteMapping("/{id_estatistica_time}")
    public void deletar(Long id_estatistica_time){
        estatistica_time.deletar(id_estatistica_time);
    }
    
    

    
    

    
}
