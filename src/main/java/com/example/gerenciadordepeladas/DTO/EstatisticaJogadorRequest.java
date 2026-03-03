package com.example.gerenciadordepeladas.DTO;

public record EstatisticaJogadorRequest(
    int gols,
    int assistencias,
    int cartoesAmarelos,
    int cartoesVermelhos,
    Long jogadorId,
    Long timeId,
    Long ligaId
    

)

{}
