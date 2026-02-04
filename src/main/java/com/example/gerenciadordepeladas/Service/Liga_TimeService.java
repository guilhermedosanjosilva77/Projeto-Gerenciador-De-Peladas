package com.example.gerenciadordepeladas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.Entity.Liga_TIme;
import com.example.gerenciadordepeladas.Repository.Liga_TimeRepository;

@Service
public class Liga_TimeService {

    private final Liga_TimeRepository liga_TimeRepository;

    public Liga_TimeService(Liga_TimeRepository liga_TimeRepository) {
        this.liga_TimeRepository = liga_TimeRepository;
    }

    //CREATE
    public Liga_TIme criar (Liga_TIme liga_TIme){
        return liga_TimeRepository.save(liga_TIme);
    }

    //READ
    public List<Liga_TIme> listar(){
        return liga_TimeRepository.findAll();
    }
    
    //READ BY ID
    public Liga_TIme listarPorId(Long id_liga_time){
        return liga_TimeRepository.findById(id_liga_time).orElse(null);

    }

    //UPDATE
    public Liga_TIme atualizar (Long id_liga_time, Liga_TIme atualizar){

        Liga_TIme liga_TIme = listarPorId(id_liga_time);

        if(liga_TIme == null){
            return null;
        }

        liga_TIme.setDerrotas(atualizar.getDerrotas());
        liga_TIme.setEmpates(atualizar.getEmpates());
        liga_TIme.setPontos(atualizar.getPontos());
        liga_TIme.setVitorias(atualizar.getVitorias());
        liga_TIme.setSaldo_de_gols(atualizar.getSaldo_de_gols());

        return liga_TimeRepository.save(liga_TIme);
        

    }

    //DELETE
    public void deletar(Long id_liga_time){
        liga_TimeRepository.deleteById(id_liga_time);
    }
}
