package com.example.gerenciadordepeladas.DTO;

import java.util.Date;
import java.util.List;

    
public record TimeResponse(
    String nomeTime, 
    String regiao, 
    Date data_criacao_time, 
    Long id,
    List<JogadorResponse> jogador
) {}