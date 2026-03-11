package com.example.gerenciadordepeladas.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.DTO.LigaRequest;
import com.example.gerenciadordepeladas.DTO.LigaResponse;
import com.example.gerenciadordepeladas.DTO.TimeSimplificado;
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
    public LigaResponse criar (LigaRequest ligaRequest){
        System.out.println(ligaRequest.timesId());
        System.out.println("JSON recebido - Nome: " + ligaRequest.nome());
        System.out.println("JSON recebido - IDs dos Times: " + ligaRequest.timesId());
        LigaEntity ligaEntity = new LigaEntity();

        ligaEntity.setNome_liga(ligaRequest.nome());
        ligaEntity.setModalidade(ligaRequest.modalidade());
        ligaEntity.setFormato(ligaRequest.formato());
        ligaEntity.setMax_times(ligaRequest.max_times());
        ligaEntity.setMin_times(ligaRequest.min_times());
        ligaEntity.setData_criacao_liga(ligaRequest.dataCriacao());

        //ESSE IF TEM A FUNÇÃO DE COMPARAR OS IDS DIGITADOS PELO USUARIO COM OS SALVOS NO BANCO DE DADOS
        //SE OS IDS NAO ESTIVEREM ASSOCIADOS A NENNHUMA LIGA, ELE FICA ASSOCIDADO A LIGA EM QUESTÃO

        if (ligaRequest.timesId() != null && !ligaRequest.timesId().isEmpty()) {
        List<TimeEntity> timesEncontrados = timeRepository.findAllById(ligaRequest.timesId());
        
        ligaEntity.setTimeEntity(timesEncontrados);
        
        //  Cada time recebe a referência da Liga (Vínculo Bidirecional)
        // É isso que preenche o id_liga na tabela de times
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
    public LigaResponse listarPorId(Long id) {
        LigaEntity liga = ligaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liga não encontrada"));
        return paraDTO(liga);
    }

    //UPDATE
    public LigaResponse atualizar(Long id_liga, LigaRequest ligaRequest) {
        LigaEntity ligaEntity = ligaRepository.findById(id_liga)
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
        //
        List<TimeSimplificado> timesDTO = (ligaEntity.getTimeEntity() != null) 
                ? ligaEntity.getTimeEntity().stream()
                    .map(times -> new TimeSimplificado(
                        times.getId_time(),
                        times.getNomeTime(),
                        times.getRegiao()
                    ))
                    .collect(Collectors.toList())
                : new ArrayList<>();
                //Collect e Collectors colocam os itens em uma nova lista
            
     
        
        //Passagem dos atributos de entity para DTO
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
