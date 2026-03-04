package com.example.gerenciadordepeladas.DTO;

import java.util.Date;
import java.util.List;

import com.example.gerenciadordepeladas.Enums.EnumFormato;
import com.example.gerenciadordepeladas.Enums.EnumModalidade;


public record LigaResponse(
    Long idLiga,
    String nome,
    EnumModalidade modalidade,
    EnumFormato formato,
    int maxTimes,
    int minTimes,
    Date data_criacao,
    List<TimeResponse> times

) {
}
