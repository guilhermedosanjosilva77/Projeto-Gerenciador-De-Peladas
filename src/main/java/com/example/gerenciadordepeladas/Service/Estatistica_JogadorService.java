package com.example.gerenciadordepeladas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.DTO.EstatisticaJogadorRequest;
import com.example.gerenciadordepeladas.DTO.EstatisticaJogadorResponse;
import com.example.gerenciadordepeladas.Entity.Estatisitca_Jogador;
import com.example.gerenciadordepeladas.Entity.JogadorEntity;
import com.example.gerenciadordepeladas.Repository.Estatistica_JogadorRepository;
import com.example.gerenciadordepeladas.Repository.JogadorRepository;
import com.example.gerenciadordepeladas.Repository.TimeRepository;

@Service
public class Estatistica_JogadorService {

    private final Estatistica_JogadorRepository estatistica_jogador;
    private final TimeRepository timeRepository;
    private final JogadorRepository jogadorRepository;

    
    
    public Estatistica_JogadorService(Estatistica_JogadorRepository estatistica_JogadorRepository,
            TimeRepository timeRepository, JogadorRepository jogadorRepository) {
        this.estatistica_jogador= estatistica_jogador;
        this.timeRepository = timeRepository;
        this.jogadorRepository = jogadorRepository;
    }

    //CREATE
    public EstatisticaJogadorResponse criar(EstatisticaJogadorRequest estatisticaRequest){
        Estatisitca_Jogador estatisitca_Jogador = new Estatisitca_Jogador();

        estatisitca_Jogador.setAssistencias(estatisticaRequest.assistencias());
        estatisitca_Jogador.setCartoes_amarelos(estatisticaRequest.cartoesAmarelos());
        estatisitca_Jogador.setCartoes_vermelhos(estatisticaRequest.cartoesVermelhos());
        estatisitca_Jogador.setGols(estatisticaRequest.gols());

        if (estatisticaRequest.jogadorId() != null) {
            JogadorEntity jogadores= jogadorRepository.findById(estatisticaRequest.jogadorId()).orElseThrow(()-> new RuntimeException("Erro eo encontrar o id"));

            estatisitca_Jogador.set
            
        }

    }

    //READ

    public List<Estatisitca_Jogador> listar(){
        return estatistica_JogadorRepository.findAll();
    }


    //READ BY ID
    public Estatisitca_Jogador listarPorId(Long id_estatistica_jogador){
        return estatistica_JogadorRepository.findById(id_estatistica_jogador).orElse(null);
    }

    //UPDATE
    public Estatisitca_Jogador atualizar(Long id_estatistica_jogador, Estatisitca_Jogador atualizar){
        Estatisitca_Jogador estatisitca_Jogador = listarPorId(id_estatistica_jogador);

        if (estatisitca_Jogador == null) {
            return null;
            
        }

        estatisitca_Jogador.setAssistencias(atualizar.getAssistencias());
        estatisitca_Jogador.setGols(atualizar.getGols());
        estatisitca_Jogador.setCartoes_amarelos(atualizar.getCartoes_amarelos());
        estatisitca_Jogador.setCartoes_vermelhos(atualizar.getCartoes_vermelhos());
        
        return estatistica_JogadorRepository.save(estatisitca_Jogador);
    }

    //DELETE
    public void deletar(Long id_estatistica_jogador){
        estatistica_JogadorRepository.deleteById(id_estatistica_jogador);
    }
    
}
