package com.example.gerenciadordepeladas.Service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.Entity.TimeEntity;
import com.example.gerenciadordepeladas.Repository.TimeRepository;

@Service
public class TImeService {

    private final TimeRepository timeRepository;

    public TImeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    //CREATE
    public TimeEntity criar (TimeEntity timeEntity){
        boolean existe = timeRepository.exiexistsByNomeTime(timeEntity.getNome_time());

        if (existe) {
            
            throw new RuntimeException("Já existe um time com esse nome");
        }
        return timeRepository.save(timeEntity);
    }

    //READ
    public List<TimeEntity> listarTime(){
        return timeRepository.findAll();
    } 

    //READ BY ID
    public TimeEntity listarPorId(Long id_time){
        return timeRepository.findById(id_time).orElse(null);
    }

    //UPDATE
    public TimeEntity atualizar (Long id_time, TimeEntity atualizar){
        TimeEntity timeEntity = listarPorId(id_time);

        if (timeEntity == null) {
            return null;
            
        }

        timeEntity.setNome_time(atualizar.getNome_time());
        timeEntity.setRegiao(atualizar.getRegiao());
        timeEntity.setEmblema(atualizar.getEmblema());
        timeEntity.setData_criacao_time(atualizar.getData_criacao_time());

        return timeRepository.save(timeEntity);
    }

    //DELETE
    public void deletar(Long id_time){
        timeRepository.deleteById(id_time);
    }
    
}
