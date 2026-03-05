package com.example.gerenciadordepeladas.DTO;

import java.util.List;

public record EstatisticaTimeRequest(
    int golsPro,
    int golsContra,
    int vitoria,
    int derrota,
    int empate,
    int saldoGols,
    List<Long> idTime
    

) {
} 
