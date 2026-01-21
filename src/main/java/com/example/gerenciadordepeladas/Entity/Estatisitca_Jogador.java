package com.example.gerenciadordepeladas.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estatistica_jogador")
public class Estatisitca_Jogador {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_estatistica_jogador;

    //FK id_jogador
    @ManyToOne 
    @JoinColumn (name = "jogador")
    private JogadorEntity jogadorEntity;
    
    //FK id_liga
    @ManyToOne
    @JoinColumn (name = "liga")
    private LigaEntity ligaEntity;

    //FK id_time
    @ManyToOne
    @JoinColumn (name = "time")
    private TimeEntity timeEntity;

    private int gols;
    private int assistencias;
    private int cartoes_amarelos;
    private int cartoes_vermelhos;
    public Estatisitca_Jogador() {
    }
    public Estatisitca_Jogador(Long id_estatistica_jogador, JogadorEntity jogadorEntity, LigaEntity ligaEntity,
            TimeEntity timeEntity, int gols, int assistencias, int cartoes_amarelos, int cartoes_vermelhos) {
        this.id_estatistica_jogador = id_estatistica_jogador;
        this.jogadorEntity = jogadorEntity;
        this.ligaEntity = ligaEntity;
        this.timeEntity = timeEntity;
        this.gols = gols;
        this.assistencias = assistencias;
        this.cartoes_amarelos = cartoes_amarelos;
        this.cartoes_vermelhos = cartoes_vermelhos;
    }
    public Long getId_estatistica_jogador() {
        return id_estatistica_jogador;
    }
    public void setId_estatistica_jogador(Long id_estatistica_jogador) {
        this.id_estatistica_jogador = id_estatistica_jogador;
    }
    public JogadorEntity getJogadorEntity() {
        return jogadorEntity;
    }
    public void setJogadorEntity(JogadorEntity jogadorEntity) {
        this.jogadorEntity = jogadorEntity;
    }
    public LigaEntity getLigaEntity() {
        return ligaEntity;
    }
    public void setLigaEntity(LigaEntity ligaEntity) {
        this.ligaEntity = ligaEntity;
    }
    public TimeEntity getTimeEntity() {
        return timeEntity;
    }
    public void setTimeEntity(TimeEntity timeEntity) {
        this.timeEntity = timeEntity;
    }
    public int getGols() {
        return gols;
    }
    public void setGols(int gols) {
        this.gols = gols;
    }
    public int getAssistencias() {
        return assistencias;
    }
    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }
    public int getCartoes_amarelos() {
        return cartoes_amarelos;
    }
    public void setCartoes_amarelos(int cartoes_amarelos) {
        this.cartoes_amarelos = cartoes_amarelos;
    }
    public int getCartoes_vermelhos() {
        return cartoes_vermelhos;
    }
    public void setCartoes_vermelhos(int cartoes_vermelhos) {
        this.cartoes_vermelhos = cartoes_vermelhos;
    }

    





    
}
