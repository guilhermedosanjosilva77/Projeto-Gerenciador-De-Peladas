package com.example.gerenciadordepeladas.DTO;

    
public record EstatisticaTimeRequest(
    int golsPro,
    int golsContra,
    int vitoria,
    int derrota,
    int empate,
    int saldoGols,
    Long idTime
    

) {
} 
