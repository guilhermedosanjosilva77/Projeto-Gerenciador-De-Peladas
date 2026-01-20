package com.example.gerenciadordepeladas.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "time")
public class TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_time;
    private String nome_time;
    private String regiao;

    //ATencao
    private String emblema;
    
    private Date data_criacao_time;

    public TimeEntity() {
    }

    public TimeEntity(Long id_time, String nome_time, String regiao, String emblema, Date data_criacao_time) {
        this.id_time = id_time;
        this.nome_time = nome_time;
        this.regiao = regiao;
        this.emblema = emblema;
        this.data_criacao_time = data_criacao_time;
    }

    public Long getId_time() {
        return id_time;
    }

    public void setId_time(Long id_time) {
        this.id_time = id_time;
    }

    public String getNome_time() {
        return nome_time;
    }

    public void setNome_time(String nome_time) {
        this.nome_time = nome_time;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getEmblema() {
        return emblema;
    }

    public void setEmblema(String emblema) {
        this.emblema = emblema;
    }

    public Date getData_criacao_time() {
        return data_criacao_time;
    }

    public void setData_criacao_time(Date data_criacao_time) {
        this.data_criacao_time = data_criacao_time;
    }

    

    
    
    
}
