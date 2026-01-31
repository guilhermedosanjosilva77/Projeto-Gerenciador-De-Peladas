package com.example.gerenciadordepeladas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.Entity.JogadorEntity;
import com.example.gerenciadordepeladas.Repository.JogadorRepository;

@Service
public class JogadorService {
    public final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    //CREATE
    public JogadorEntity criar (JogadorEntity jogadorEntity){
        return jogadorRepository.save(jogadorEntity);

    }

    //READ
    public List<JogadorEntity> listarJogadores(){
       return jogadorRepository.findAll();
    }

    //READ BY ID
    public JogadorEntity listarPorId(Long id_jogador){
        return jogadorRepository.findById(id_jogador).orElse(null);
    }

    //UPDATE
    public JogadorEntity atualizar(Long id_jogador, JogadorEntity atualizar){
        JogadorEntity jogadorEntity = listarPorId(id_jogador);

        if (jogadorEntity == null) {
            return null;
            
        }
        jogadorEntity.setNome(atualizar.getNome());
        jogadorEntity.setPosicao(atualizar.getPosicao());
        jogadorEntity.setFoto(atualizar.getFoto());
        jogadorEntity.setStatus(atualizar.getStatus());
        jogadorEntity.setData_criaçao(atualizar.getData_criaçao());

        return jogadorRepository.save(jogadorEntity);
    }

    //DELETE
    public void deletar (Long id_jogador){
        jogadorRepository.deleteById(id_jogador);
    }
    
}
