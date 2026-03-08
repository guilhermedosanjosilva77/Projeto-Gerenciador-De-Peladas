package com.example.gerenciadordepeladas.Service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.example.gerenciadordepeladas.DTO.EstatisticaJogadorRequest;
import com.example.gerenciadordepeladas.DTO.EstatisticaJogadorResponse;
import com.example.gerenciadordepeladas.DTO.JogadorSimplificado;
import com.example.gerenciadordepeladas.Entity.Estatisitca_Jogador;
import com.example.gerenciadordepeladas.Entity.JogadorEntity;
import com.example.gerenciadordepeladas.Entity.TimeEntity;
import com.example.gerenciadordepeladas.Repository.Estatistica_JogadorRepository;
import com.example.gerenciadordepeladas.Repository.JogadorRepository;

@Service
public class Estatistica_JogadorService {

    private final Estatistica_JogadorRepository estatistica_jogador;
    private final JogadorRepository jogadorRepository;

    public Estatistica_JogadorService(Estatistica_JogadorRepository estatistica_jogador,
            JogadorRepository jogadorRepository) {
        this.estatistica_jogador = estatistica_jogador;
        this.jogadorRepository = jogadorRepository;
    }

    //CREATE
    public EstatisticaJogadorResponse criar(EstatisticaJogadorRequest estatisticaRequest){
        Estatisitca_Jogador estatisitca_Jogador = new Estatisitca_Jogador();

        estatisitca_Jogador.setAssistencias(estatisticaRequest.assistencias());
        estatisitca_Jogador.setCartoes_amarelos(estatisticaRequest.cartoesAmarelos());
        estatisitca_Jogador.setCartoes_vermelhos(estatisticaRequest.cartoesVermelhos());
        estatisitca_Jogador.setGols(estatisticaRequest.gols());


        //Pesquisar se o id de jogador existe e adicionar ele 
        if (estatisticaRequest.jogadorId() != null) {
            JogadorEntity jogadores= jogadorRepository.findById(estatisticaRequest.jogadorId()).orElseThrow(()-> new RuntimeException("Erro eo encontrar o id"));
          
            estatisitca_Jogador.setJogadorEntity(jogadores);
        }
        estatistica_jogador.save(estatisitca_Jogador);

        return paraDTO(estatisitca_Jogador);

    }

    //READ

    public List<EstatisticaJogadorResponse> listar(){
        return estatistica_jogador.findAll().stream().map(this::paraDTO).collect(Collectors.toList());
    }


    //READ BY ID
    public EstatisticaJogadorResponse listarPorId(Long id_estatistica_jogador){
        Estatisitca_Jogador estatistica_BuscarPorId = estatistica_jogador.findById(id_estatistica_jogador).orElseThrow(()-> new RuntimeException("Erro ao buscar o id"));

        return paraDTO(estatistica_BuscarPorId);
    }

    //UPDATE
    public EstatisticaJogadorResponse atualizar(Long id_estatistica_jogador, EstatisticaJogadorRequest estatisticaRequest){
        Estatisitca_Jogador estatisitca_Jogador = estatistica_jogador.findById(id_estatistica_jogador).orElseThrow(()-> new RuntimeException("Erro ao buscar o id"));

        estatisitca_Jogador.setAssistencias(estatisticaRequest.assistencias());
        estatisitca_Jogador.setCartoes_amarelos(estatisticaRequest.cartoesAmarelos());
        estatisitca_Jogador.setCartoes_vermelhos(estatisticaRequest.cartoesVermelhos());
        estatisitca_Jogador.setGols(estatisticaRequest.gols());

        TimeEntity timeEntity = new TimeEntity();

        if (estatisticaRequest.jogadorId() != null) {
            JogadorEntity jogadores= jogadorRepository.findById(estatisticaRequest.jogadorId()).orElseThrow(()-> new RuntimeException("Erro eo encontrar o id"));
          
            estatisitca_Jogador.setJogadorEntity(jogadores);
        }
        estatistica_jogador.save(estatisitca_Jogador);
        
        return paraDTO(estatisitca_Jogador);
    }

    //DELETE
    public void deletar(Long id_estatistica_jogador){
        estatistica_jogador.deleteById(id_estatistica_jogador);
    }
    

    public EstatisticaJogadorResponse paraDTO(Estatisitca_Jogador estatisitcaJogador){

        JogadorSimplificado jogadorDTO = null;

        //Como time recebe um id, temos que primeiro fazer uma busca desse id para ver se não esta vazio ou não existe
          if (estatisitcaJogador.getJogadorEntity() != null) {
        Long idTime = null;
        if (estatisitcaJogador.getJogadorEntity().getTimeEntity() != null) {
            idTime = estatisitcaJogador.getJogadorEntity().getTimeEntity().getId_time();
        }

        //DTO simplificado para a listagem do jogador
        jogadorDTO = new JogadorSimplificado(
            estatisitcaJogador.getJogadorEntity().getId_jogador(),
            estatisitcaJogador.getJogadorEntity().getNome(),
            idTime
        );
    }

    //Passagem dos atributos de entity para DTO
    return new EstatisticaJogadorResponse(
        estatisitcaJogador.getId_estatistica_jogador(),
        estatisitcaJogador.getGols(),
        estatisitcaJogador.getAssistencias(),
        estatisitcaJogador.getCartoes_amarelos(),
        estatisitcaJogador.getCartoes_vermelhos(),
        jogadorDTO 
    );




    }
}
