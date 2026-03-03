package com.example.gerenciadordepeladas.DTO;

import java.util.List;
import com.example.gerenciadordepeladas.Enums.EnumFormato;
import com.example.gerenciadordepeladas.Enums.EnumModalidade;


public record LigaRequest
(
    String nome,
    EnumModalidade modalidade,
    EnumFormato formato,
    int max_times,
    int min_times,
    List<Long> timesId
    

    

    ) {
} 
