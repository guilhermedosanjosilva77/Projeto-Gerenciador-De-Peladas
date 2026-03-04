package com.example.gerenciadordepeladas.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.DTO.LigaRequest;
import com.example.gerenciadordepeladas.DTO.LigaResponse;
import com.example.gerenciadordepeladas.DTO.TimeResponse;
import com.example.gerenciadordepeladas.Entity.LigaEntity;
import com.example.gerenciadordepeladas.Entity.TimeEntity;
import com.example.gerenciadordepeladas.Repository.LigaRepository;
import com.example.gerenciadordepeladas.Repository.TimeRepository;

@Service
public class LigaService {
    private final LigaRepository ligaRepository;
    private final TimeRepository timeRepository;

    
    public LigaService(LigaRepository ligaRepository, TimeRepository timeRepository) {
        this.ligaRepository = ligaRepository;
        this.timeRepository = timeRepository;
    }

    //CREATE
    public LigaResponse criar (LigaRequest ligaRequest, Long id_liga){
        LigaEntity ligaEntity = new LigaEntity();

        ligaEntity.setNome_liga(ligaRequest.nome());
        ligaEntity.setModalidade(ligaRequest.modalidade());
        ligaEntity.setFormato(ligaRequest.formato());
        ligaEntity.setMax_times(ligaRequest.max_times());
        ligaEntity.setMin_times(ligaRequest.min_times());
        ligaEntity.setData_criacao_liga(ligaRequest.dataCriacao());

        //ESSE IF TEM A FUNÇÃO DE VER COMPARAR OS IDS DIGITADOS PELO USUARIO COM OS SALVOS NO BANCO DE DADOS
        //SE OS IDS NAO ESTIVEREM ASSOCIADOS A NENNHUM, ELE FICA ASSOCIDADO A LIGA EM QUESTÃO
        if (ligaRequest.timesId() != null && !ligaRequest.timesId().isEmpty()) {
        List<TimeEntity> timesEncontrados = timeRepository.findAllById(ligaRequest.timesId());
        
        ligaEntity.setTimeEntity(timesEncontrados);
        
        timesEncontrados.forEach(time -> time.setLigaEntity(ligaEntity));
    }
        ligaRepository.save(ligaEntity);

        return paraDTO(ligaEntity);
    }

    //READ
    public List<LigaResponse> listar(){
        return ligaRepository.findAll().stream()
                .map(this::paraDTO)
                .collect(Collectors.toList());

    }

    //READ BY ID
    public LigaResponse buscarPorId(Long id) {
        LigaEntity liga = ligaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liga não encontrada"));
        return paraDTO(liga);
    }

    //UPDATE
    public LigaResponse atualizar(Long id, LigaRequest ligaRequest) {
        LigaEntity ligaEntity = ligaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liga não encontrada"));

        ligaEntity.setNome_liga(ligaRequest.nome());
        ligaEntity.setModalidade(ligaRequest.modalidade());
        ligaEntity.setFormato(ligaRequest.formato());
        ligaEntity.setMax_times(ligaRequest.max_times());
        ligaEntity.setMin_times(ligaRequest.min_times());
        ligaEntity.setData_criacao_liga(ligaRequest.dataCriacao());

        if (ligaRequest.timesId() != null) {
        List<TimeEntity> novosTimes = timeRepository.findAllById(ligaRequest.timesId());
        
        // limpeza das ligações antigas, garantindo que os ids não fiquem presos por acidente na liga
        if (ligaEntity.getTimeEntity() != null) {
            ligaEntity.getTimeEntity().forEach(time -> time.setLigaEntity(null));
        }

        // Agora associamos os novos times
        ligaEntity.setTimeEntity(novosTimes);
    }

        ligaRepository.save(ligaEntity);

        return paraDTO(ligaEntity);

    }
    


    //DELETE
    public void deletar(Long id_liga){
        ligaRepository.deleteById(id_liga);

    }

    private LigaResponse paraDTO(LigaEntity ligaEntity) {
        // Proteção contra NullPointerException na lista de times
        List<TimeResponse> timesDTO = (ligaEntity.getTimeEntity() != null) 
                ? ligaEntity.getTimeEntity().stream()
                    .map(time -> new TimeResponse(
                        time.getNomeTime(),
                        time.getRegiao(),
                        time.getData_criacao_time(),
                        time.getId_time(),
                        new ArrayList<>() 
                    ))
                    .collect(Collectors.toList())
                : new ArrayList<>();
                //Collect e Collectors colocam os itens em uma nova lista

        return new LigaResponse(
               ligaEntity.getId_liga(),
            ligaEntity.getNome_liga(),
            ligaEntity.getModalidade(), 
            ligaEntity.getFormato(),   
            ligaEntity.getMax_times(),
            ligaEntity.getMin_times(),
            ligaEntity.getData_criacao_liga(),
            timesDTO              
    );
    }

    

    
}
