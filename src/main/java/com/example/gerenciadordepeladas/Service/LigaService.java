package com.example.gerenciadordepeladas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.Entity.LigaEntity;
import com.example.gerenciadordepeladas.Repository.LigaRepository;

@Service
public class LigaService {
    private final LigaRepository ligaRepository;

    public LigaService(LigaRepository ligaRepository) {
        this.ligaRepository = ligaRepository;
    }

    //CREATE
    public LigaEntity criar (LigaEntity ligaEntity){
        return ligaRepository.save(ligaEntity);
    }

    //READ
    public List<LigaEntity> listarLiga(){
        return ligaRepository.findAll();

    }

    //READ BY ID
    public LigaEntity listarPorId(Long id_liga){
        return ligaRepository.findById(id_liga).orElse(null);
    }

    //UPDATE
    public LigaEntity atualizar(LigaEntity atualizar, Long id_Liga){
        LigaEntity ligaEntity = listarPorId(id_Liga);

        if (ligaEntity == null) {
            return null;
            
        }
        ligaEntity.setNome_liga(atualizar.getNome_liga());
        ligaEntity.setRegiao_lga(atualizar.getRegiao_lga());
        ligaEntity.setModalidade(atualizar.getModalidade());
        ligaEntity.setFormato(atualizar.getFormato());
        ligaEntity.setMin_times(atualizar.getMin_times());
        ligaEntity.setMax_times(atualizar.getMax_times());
        ligaEntity.setEmblema(atualizar.getEmblema());
        ligaEntity.setStatus(atualizar.getStatus());
        ligaEntity.setData_criacao_liga(atualizar.getData_criacao_liga());

        return ligaRepository.save(ligaEntity);

    }


    //DELETE
    public void deletar(Long id_liga){
        ligaRepository.deleteById(id_liga);

    }

    

    
}
