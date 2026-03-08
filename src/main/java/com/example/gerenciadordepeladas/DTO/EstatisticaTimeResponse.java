package com.example.gerenciadordepeladas.DTO;



public record EstatisticaTimeResponse(
    Long id_estatistica_time,
    int golsPro,
    int golsContra,
    int vitoria,
    int derrota,
    int empate,
    int saldoGols,
    TimeSimplificado LigaId
) {

} 
