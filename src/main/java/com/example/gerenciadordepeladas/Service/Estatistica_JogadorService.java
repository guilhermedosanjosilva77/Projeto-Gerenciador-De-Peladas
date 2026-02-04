package com.example.gerenciadordepeladas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.Entity.Estatisitca_Jogador;
import com.example.gerenciadordepeladas.Repository.Estatistica_JogadorRepository;

@Service
public class Estatistica_JogadorService {

    private final Estatistica_JogadorRepository estatistica_JogadorRepository;

    public Estatistica_JogadorService(Estatistica_JogadorRepository estatistica_JogadorRepository) {
        this.estatistica_JogadorRepository = estatistica_JogadorRepository;
    }

    
    //CREATE
    public Estatisitca_Jogador criar(Estatisitca_Jogador estatistica_Jogador){
        return estatistica_JogadorRepository.save(estatistica_Jogador);
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
