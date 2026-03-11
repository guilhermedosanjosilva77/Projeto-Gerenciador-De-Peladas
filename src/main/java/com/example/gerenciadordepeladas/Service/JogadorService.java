package com.example.gerenciadordepeladas.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.DTO.JogadorRequest;
import com.example.gerenciadordepeladas.DTO.JogadorResponse;
import com.example.gerenciadordepeladas.Entity.JogadorEntity;
import com.example.gerenciadordepeladas.Entity.TimeEntity;
import com.example.gerenciadordepeladas.Repository.JogadorRepository;
import com.example.gerenciadordepeladas.Repository.TimeRepository;

@Service
public class JogadorService {
    public final JogadorRepository jogadorRepository;
    public final TimeRepository timeRepository;

    

    //CREATE
    public JogadorService(JogadorRepository jogadorRepository, TimeRepository timeRepository) {
        this.jogadorRepository = jogadorRepository;
        this.timeRepository = timeRepository;
    }

    public JogadorResponse criar (JogadorRequest jogadorRequest){
        //Verifica se o time existe
        TimeEntity timeEntity = timeRepository.findById(jogadorRequest.id_time()).orElseThrow(() -> new RuntimeException("Erro:Time não existe"));

        JogadorEntity jogadorEntity = new JogadorEntity();

        jogadorEntity.setNome(jogadorRequest.nome());
        jogadorEntity.setIdade(jogadorRequest.idade());
        jogadorEntity.setPosicao(jogadorRequest.posicao());
        jogadorEntity.setStatus(jogadorRequest.status());
        jogadorEntity.setTimeEntity(timeEntity);

        jogadorRepository.save(jogadorEntity);

        return paraDTO(jogadorEntity);

    }

    //READ
    public List<JogadorResponse> listarJogadores(){
       return jogadorRepository.findAll().stream().map(this::paraDTO).collect(Collectors.toList());
    }

    //READ BY ID
    public JogadorResponse listarPorId(Long id_jogador){
        JogadorEntity jogadorEntity = jogadorRepository.findById(id_jogador).orElseThrow(()-> new RuntimeException("Jogador não encontrado"));

        return paraDTO(jogadorEntity);
    }

    //UPDATE
    public JogadorResponse atualizar(Long id_jogador, JogadorRequest jogadorRequest){
        JogadorEntity jogadorEntity = jogadorRepository.findById(id_jogador).orElseThrow(()-> new RuntimeException("Jogador não encontrado"));
        
        //Verifica se o time novo, realmente existe 
        TimeEntity timeEntity = timeRepository.findById(jogadorRequest.id_time()).orElseThrow(()-> new RuntimeException("Time não encontrado"));
        jogadorEntity.setNome(jogadorRequest.nome());
        jogadorEntity.setIdade(jogadorRequest.idade());
        jogadorEntity.setPosicao(jogadorRequest.posicao());
        jogadorEntity.setStatus(jogadorRequest.status());
        jogadorEntity.setTimeEntity(timeEntity);

        jogadorRepository.save(jogadorEntity);

        return paraDTO(jogadorEntity);  
    }

    //DELETE
    public void deletar (Long id_jogador){
        //Busca o jogador pelo ID antes de apagar
        JogadorEntity jogadorEntity = jogadorRepository.findById(id_jogador).orElseThrow(()-> new RuntimeException("ERRO: Id não encontrado"));
        jogadorRepository.deleteById(id_jogador);
    }

    //Método que transforma entitys em DTO
    private JogadorResponse paraDTO(JogadorEntity jogadorEntity){
        return new JogadorResponse(
            jogadorEntity.getId_jogador(),
            jogadorEntity.getNome(),
            jogadorEntity.getIdade(),
            jogadorEntity.getPosicao(),
            jogadorEntity.getStatus(),
            jogadorEntity.getTimeEntity() != null ? jogadorEntity.getTimeEntity().getId_time() : null
        );
    }
    
}
