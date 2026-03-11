package com.example.gerenciadordepeladas.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.DTO.JogadorForTime;
import com.example.gerenciadordepeladas.DTO.TimeRequest;
import com.example.gerenciadordepeladas.DTO.TimeResponse;
import com.example.gerenciadordepeladas.Entity.JogadorEntity;
import com.example.gerenciadordepeladas.Entity.TimeEntity;
import com.example.gerenciadordepeladas.Repository.TimeRepository;

@Service
public class TimeService {
    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    //CREATE
    public TimeResponse criar(TimeRequest timeRequest){
        TimeEntity timeEntity = new TimeEntity();
        timeEntity.setNomeTime(timeRequest.nomeTime());
        timeEntity.setRegiao(timeRequest.regiao());
        timeEntity.setData_criacao_time(timeRequest.data_criacao_time());

        timeRepository.save(timeEntity);

        return paraDTO(timeEntity);

    }

    //READ
    public List<TimeResponse>buscar(){
        return timeRepository.findAll().stream()
                .map(this::paraDTO)
                .collect(Collectors.toList());

    }

    //READ BY ID
    public TimeResponse listarPorID(Long id_time){
        TimeEntity timeEntity = timeRepository.findById(id_time).orElseThrow(()-> new RuntimeException("Time não encontrado!!")); 
        
        return paraDTO(timeEntity);
    }

    //Atualizar
    public TimeResponse atualizar(Long id_time, TimeRequest timeRequest){
        TimeEntity timeEntity = timeRepository.findById(id_time).orElseThrow(()-> new RuntimeException("Time não encontrado!!")); 

        timeEntity.setNomeTime(timeRequest.nomeTime());
        timeEntity.setRegiao(timeRequest.regiao());
        timeEntity.setData_criacao_time(timeRequest.data_criacao_time());

        timeRepository.save(timeEntity);

        return paraDTO(timeEntity);
    }

    //DELETAR
    public void deletar(Long id_time){
        TimeEntity timeEntity = timeRepository.findById(id_time).orElseThrow(()-> new RuntimeException("Time não encontrado!!")); 

        timeRepository.deleteById(id_time);



    }





    //MÉTODO TRADUTOR (ENTITY -> DTO)
    private TimeResponse paraDTO(TimeEntity timeEntity){

        List<JogadorEntity> listaJogadores;

        if (timeEntity.getJogadorEntity() != null) {
            listaJogadores = timeEntity.getJogadorEntity();
            }
            else{
                listaJogadores= new ArrayList<>();
            }
        List<JogadorForTime> jogadoresDTO = listaJogadores.stream()
                .map(jogador -> new JogadorForTime(
                    jogador.getId_jogador(),
                    jogador.getNome(),
                    jogador.getIdade(),
                    jogador.getPosicao()

                ))
                .toList();
            
            //Permite que quando o time não estiver associado a nenhuma liga, não tenha erro
            Long idLiga = null;

            if (timeEntity.getLigaEntity() != null) {
                idLiga = timeEntity.getLigaEntity().getId_liga();
                
            }
        
    //Passagem dos atributos de entity para DTO
        return new TimeResponse(
            timeEntity.getNomeTime(),
            timeEntity.getRegiao(),
            timeEntity.getData_criacao_time(),
            timeEntity.getId_time(),
            jogadoresDTO,
            idLiga
        );

    }


    
}
