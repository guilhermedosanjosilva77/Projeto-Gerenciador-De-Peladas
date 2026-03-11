package com.example.gerenciadordepeladas.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "time")
public class TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_time;

    //Um time pode ter muitos jogadores (Um > Muitos)
    @OneToMany (mappedBy = "timeEntity")
    private List<JogadorEntity> jogadorEntity = new ArrayList<>();

    //tabela estatistica time
    @OneToOne (mappedBy = "timeEntity",cascade = CascadeType.ALL, orphanRemoval = true)
    private Estatistica_time estatistica_time;

    @ManyToOne //Nome no banco de dados
    @JoinColumn(name = "id_liga")
    private LigaEntity ligaEntity;

    @NotBlank(message = "O time precisa de um nome")
    private String nomeTime;

    @NotBlank(message = "O jogador precisa de uma região")
    private String regiao;
    private Date data_criacao_time;

    public TimeEntity() {
    }

    

    public TimeEntity(Long id_time, List<JogadorEntity> jogadorEntity, Estatistica_time estatistica_time,
            LigaEntity ligaEntity, String nomeTime, String regiao, Date data_criacao_time) {
        this.id_time = id_time;
        this.jogadorEntity = jogadorEntity;
        this.estatistica_time = estatistica_time;
        this.ligaEntity = ligaEntity;
        this.nomeTime = nomeTime;
        this.regiao = regiao;
        this.data_criacao_time = data_criacao_time;
    }



    public Long getId_time() {
        return id_time;
    }

    public void setId_time(Long id_time) {
        this.id_time = id_time;
    }

    public Estatistica_time getEstatistica_time() {
        return estatistica_time;
    }

    public void setEstatistica_time(Estatistica_time estatistica_time) {
        this.estatistica_time = estatistica_time;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Date getData_criacao_time() {
        return data_criacao_time;
    }

    public void setData_criacao_time(Date data_criacao_time) {
        this.data_criacao_time = data_criacao_time;
    }



    public List<JogadorEntity> getJogadorEntity() {
        return jogadorEntity;
    }



    public void setJogadorEntity(List<JogadorEntity> jogadorEntity) {
        this.jogadorEntity = jogadorEntity;
    }



    public LigaEntity getLigaEntity() {
        return ligaEntity;
    }



    public void setLigaEntity(LigaEntity ligaEntity) {
        this.ligaEntity = ligaEntity;
    }
    

    

}

    