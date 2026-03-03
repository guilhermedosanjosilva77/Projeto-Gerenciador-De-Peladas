package com.example.gerenciadordepeladas.DTO;

import com.example.gerenciadordepeladas.Enums.EnumPosicao;


public record JogadorRequest(Long id,  String nome, EnumPosicao posicao,String status,Long id_time) {
    
}
