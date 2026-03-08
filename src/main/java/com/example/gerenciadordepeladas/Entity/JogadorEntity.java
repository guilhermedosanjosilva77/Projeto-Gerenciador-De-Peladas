package com.example.gerenciadordepeladas.Entity;


import com.example.gerenciadordepeladas.Enums.EnumPosicao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogador")
public class JogadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_jogador;

    //Relacionamento tabela estatistica jogador
    @OneToOne (mappedBy = "jogadorEntity",cascade = CascadeType.ALL, orphanRemoval = true)
    private Estatisitca_Jogador estatisitca_Jogador;

    //Chave estrangeira da tabela TimeEntity, que serve para indicar o time em que o jogador pertence
    @ManyToOne
    @JoinColumn(name = "id_time")
    private TimeEntity timeEntity;

    private String nome;


    @Enumerated (EnumType.STRING)
    private EnumPosicao posicao;

    private String status;

    public JogadorEntity() {
    }

    public JogadorEntity(Long id_jogador, Estatisitca_Jogador estatisitca_Jogador,
            String nome, EnumPosicao posicao, String status,TimeEntity timeEntity) {
        this.id_jogador = id_jogador;
        this.estatisitca_Jogador = estatisitca_Jogador;
        this.nome = nome;
        this.posicao = posicao;
        this.status = status;
        this.timeEntity = timeEntity;
    }

    public Long getId_jogador() {
        return id_jogador;
    }

    public void setId_jogador(Long id_jogador) {
        this.id_jogador = id_jogador;
    }

    public Estatisitca_Jogador getEstatisitca_Jogador() {
        return estatisitca_Jogador;
    }

    public void setEstatisitca_Jogador(Estatisitca_Jogador estatisitca_Jogador) {
        this.estatisitca_Jogador = estatisitca_Jogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnumPosicao getPosicao() {
        return posicao;
    }

    public void setPosicao(EnumPosicao posicao) {
        this.posicao = posicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TimeEntity getTimeEntity() {
        return timeEntity;
    }

    public void setTimeEntity(TimeEntity timeEntity) {
        this.timeEntity = timeEntity;
    }

    

    

    

}

