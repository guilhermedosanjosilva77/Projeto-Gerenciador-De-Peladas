package com.example.gerenciadordepeladas.Service;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.Entity.Time_Jogador;
import com.example.gerenciadordepeladas.Repository.Time_JogadorRepository;

@Service
public class Time_JogadorService {

    private final Time_JogadorRepository time_JogadorRepository;

    public Time_JogadorService(Time_JogadorRepository time_JogadorRepository) {
        this.time_JogadorRepository = time_JogadorRepository;
    }

    //CREATE
    public Time_Jogador criar(Time_Jogador time_Jogador){
        return time_JogadorRepository.save(time_Jogador);
    }

    //READ
    public List<Time_Jogador>listar(){
        return time_JogadorRepository.findAll();
    }

    //READ BY ID
    public Time_Jogador listarPorId(Long id_time_jogador){
        return time_JogadorRepository.findById(id_time_jogador).orElse(null);
    }

    //UPDATE
    public Time_Jogador atualizar (Long id_time_jogador, Time_Jogador atualizar){
        Time_Jogador time_Jogador = listarPorId(id_time_jogador);

        if(time_Jogador == null){
            return null;
        }

        time_Jogador.set
    }

    
    
}
