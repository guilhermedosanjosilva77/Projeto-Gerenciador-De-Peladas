package com.example.gerenciadordepeladas.Service;

import java.util.List;

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
        return timeRepository.save(timeEntity);
    }

    //READ
    public List<TimeEntity> listarTime(){
        return timeRepository.findAll();
    } 

    
    
}
