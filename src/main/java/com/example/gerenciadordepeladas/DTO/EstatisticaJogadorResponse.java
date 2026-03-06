package com.example.gerenciadordepeladas.DTO;

public record EstatisticaJogadorResponse(
    Long id_estatistica_jogador,
    int gols,
    int assistencias,
    int cartoesAmarelos,
    int cartoesVermelhos,
    Long jogadorId,
    Long timeId,
    TimeSimplificado ligaId
) {
}
