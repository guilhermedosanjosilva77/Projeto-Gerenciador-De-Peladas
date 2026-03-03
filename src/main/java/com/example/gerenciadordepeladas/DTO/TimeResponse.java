package com.example.gerenciadordepeladas.DTO;

import java.util.Date;

import com.example.gerenciadordepeladas.Entity.TimeEntity;

public record TimeResponse(String nomeTime, String regiao, Date data_criacao_time, Long id){
    public TimeResponse(TimeEntity timeEntity) {
        this(
            timeEntity.getNomeTime(),
            timeEntity.getRegiao(),
            timeEntity.getData_criacao_time(),
            timeEntity.get


        );
        
    } 
} 
