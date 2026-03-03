package com.example.gerenciadordepeladas.DTO;

import java.util.List;
import jakarta.persistence.Enumerated;

public record LigaResponse(
    Long idLiga,
    String nome,
    Enumerated modalidade,
    Enumerated formato,
    int maxTimes,
    int minTimes,
    List<TimeResponse> times,
    List<EstatisticaTimeResponse> estatistica_times

) {
}
