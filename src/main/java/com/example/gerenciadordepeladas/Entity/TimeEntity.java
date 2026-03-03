package com.example.gerenciadordepeladas.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "time")
public class TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_time;

    //Um time pode ter muitos jogadores (Um > Muitos)
    @OneToMany (mappedBy = "timeEntity")
    private List<JogadorEntity> jogadorEntity;

    //tabela estatistica time
    @OneToMany (mappedBy = "timeEntity")
    private List <Estatistica_time> estatistica_time;


    private String nomeTime;
    private String regiao;
    private Date data_criacao_time;

    public TimeEntity() {
    }

    public TimeEntity(Long id_time, List<Estatistica_time> estatistica_time, String nomeTime,
            String regiao, Date data_criacao_time) {
        this.id_time = id_time;
        this.estatistica_time = estatistica_time;
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

    public List<Estatistica_time> getEstatistica_time() {
        return estatistica_time;
    }

    public void setEstatistica_time(List<Estatistica_time> estatistica_time) {
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

    

    

}

    