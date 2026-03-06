package com.example.gerenciadordepeladas.DTO;

import java.util.List;


public record EstatisticaTimeResponse(
    Long id_estatistica_time,
    int golsPro,
    int golsContra,
    int vitoria,
    int derrota,
    int empate,
    int saldoGols,
    List<TimeSimplificado> time
) {

} 
