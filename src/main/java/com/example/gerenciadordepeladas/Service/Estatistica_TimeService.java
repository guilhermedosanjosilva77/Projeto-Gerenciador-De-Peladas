package com.example.gerenciadordepeladas.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.DTO.EstatisticaTimeRequest;
import com.example.gerenciadordepeladas.DTO.EstatisticaTimeResponse;
import com.example.gerenciadordepeladas.Entity.Estatistica_time;
import com.example.gerenciadordepeladas.Entity.TimeEntity;
import com.example.gerenciadordepeladas.Repository.Estatistica_TimeRepository;
import com.example.gerenciadordepeladas.Repository.TimeRepository;

@Service
public class Estatistica_TimeService {
    private final Estatistica_TimeRepository estatistica_TimeRepository;
    private final TimeRepository timeRepository;

    public Estatistica_TimeService(Estatistica_TimeRepository estatistica_TimeRepository,TimeRepository timeRepository) {
        this.estatistica_TimeRepository = estatistica_TimeRepository;
        this.timeRepository = timeRepository;
    }

    //CREATE 
    public EstatisticaTimeResponse criar(EstatisticaTimeRequest estatisticaTimeRequest){
        Estatistica_time estatistica_time = new Estatistica_time();

        estatistica_time.setDerrota(estatisticaTimeRequest.derrota());
        estatistica_time.setEmpate(estatisticaTimeRequest.empate());
        estatistica_time.setVitoria(estatisticaTimeRequest.vitoria());
        estatistica_time.setGols_pro(estatisticaTimeRequest.golsPro());
        estatistica_time.setGols_contra(estatisticaTimeRequest.golsContra());
        estatistica_time.setSaldoGols(estatisticaTimeRequest.saldoGols());


        //Comparar se o id do time existe, e se existe associar as estatisticas naquele time
        if (estatisticaTimeRequest.idTime() != null && !estatisticaTimeRequest.idTime().isEmpty()) {

        List<TimeEntity> timesEncontrados = timeRepository.findAllById(estatisticaTimeRequest.idTime());
        
        estatistica_time.setTimeEntity(timesEncontrados);

        }

    estatistica_TimeRepository.save(estatistica_time);

    return paraDTO(estatistica_time);



    }

    //READ
    public List<EstatisticaTimeResponse> listar(){
        return estatistica_TimeRepository.findAll().stream().map(this::paraDTO).collect(Collectors.toList());
    }

    //READ BY ID
    public EstatisticaTimeResponse listarPorId(Long id_estatistica_time){
        
    Estatistica_time estatistica =estatistica_TimeRepository.findById(id_estatistica_time).orElseThrow(()-> new RuntimeException("Erro ao buscar o id"));

    return paraDTO(id_estatistica)
    }

    //UPDATE
    public EstatisticaTimeResponse atualizar (Long id_estatistica_time,EstatisticaTimeRequest estatistica ){
        Estatistica_time estatistica_time = estatistica_TimeRepository.findById(id_estatistica_time).orElseThrow(()-> new RuntimeException("Erro ao buscar o id"));

       estatistica_time.setGols_pro(estatistica.golsPro());
    estatistica_time.setGols_contra(estatistica.golsContra());
    estatistica_time.setVitoria(estatistica.vitoria());
    estatistica_time.setDerrota(estatistica.derrota());
    estatistica_time.setEmpate(estatistica.empate());
    estatistica_time.setSaldoGols(estatistica.saldoGols());

   if (estatistica.idTime() != null && !estatistica.idTime().isEmpty()) {

        List<TimeEntity> timesEncontrados = timeRepository.findAllById(estatisticagit.idTime());
        
        estatistica_time.setTimeEntity(timesEncontrados);

        }

    estatistica_TimeRepository.save(estatistica_time);

    return paraDTO(estatistica_time);


        }

    //DELETE
    public void deletar(Long id_estatistica_time){
        estatistica_TimeRepository.deleteById(id_estatistica_time);
    }

    
    
}
