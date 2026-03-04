package com.example.gerenciadordepeladas.DTO;

import java.sql.Date;
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
    Date dataCriacao,
    List<Long> timesId
    

    

    ) {
} 
