package com.example.gerenciadordepeladas.DTO;

import java.util.Date;
import java.util.List;

    
public record TimeResponse(
    String nomeTime, 
    String regiao, 
    Date data_criacao_time, 
    Long id_Time,
    List<JogadorForTime> jogador,
    Long id_liga
    
) {}