package com.example.gerenciadordepeladas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.Entity.Estatisitca_Jogador;
import com.example.gerenciadordepeladas.Entity.Estatistica_time;
import com.example.gerenciadordepeladas.Repository.Estatistica_TimeRepository;

@Service
public class Estatistica_TimeService {
    private final Estatistica_TimeRepository estatistica_TimeRepository;

    public Estatistica_TimeService(Estatistica_TimeRepository estatistica_TimeRepository) {
        this.estatistica_TimeRepository = estatistica_TimeRepository;
    }

    //CREATE 
    public Estatistica_time criar(Estatistica_time estatistica_time){
        return estatistica_TimeRepository.save(estatistica_time);
    }

    //READ
    public List<Estatistica_time> listar(){
        return estatistica_TimeRepository.findAll();
    }

    //READ BY ID
    public Estatistica_time listarPorId(Long id_estatistica_time){
        return estatistica_TimeRepository.findById(id_estatistica_time).orElse(null);
    }

    //UPDATE
    public Estatistica_time atualizar (Long id_estatistica_time,Estatistica_time atualizar ){
        Estatistica_time estatistica_time = listarPorId(id_estatistica_time);

        if(estatistica_time == null){
            return null;
        }

        estatistica_time.setGols_contra(atualizar.getGols_contra());
        estatistica_time.setGols_pro(atualizar.getGols_pro());

        return estatistica_TimeRepository.save(estatistica_time);


        }

    //DELETE
    public void deletar(Long id_estatistica_time){
        estatistica_TimeRepository.deleteById(id_estatistica_time);
    }

    
    
}
