package com.example.gerenciadordepeladas.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "liga")
public class LigaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_liga;
    private String nome_liga;
    private String regiao_lga;

    //atencao
    private String modalidade;

    //atencao
    private String formato;

    private int min_times;
    private int max_times;

    //Atencao
    private String emblema;

    //Atencao
    private String status;
    private Date data_criacao_liga;

    public LigaEntity() {
    }

    public LigaEntity(Long id_liga, String nome_liga, String regiao_lga, String modalidade, String formato,
            int min_times, int max_times, String emblema, String status, Date data_criacao_liga) {
        this.id_liga = id_liga;
        this.nome_liga = nome_liga;
        this.regiao_lga = regiao_lga;
        this.modalidade = modalidade;
        this.formato = formato;
        this.min_times = min_times;
        this.max_times = max_times;
        this.emblema = emblema;
        this.status = status;
        this.data_criacao_liga = data_criacao_liga;
    }

    public Long getId_liga() {
        return id_liga;
    }

    public void setId_liga(Long id_liga) {
        this.id_liga = id_liga;
    }

    public String getNome_liga() {
        return nome_liga;
    }

    public void setNome_liga(String nome_liga) {
        this.nome_liga = nome_liga;
    }

    public String getRegiao_lga() {
        return regiao_lga;
    }

    public void setRegiao_lga(String regiao_lga) {
        this.regiao_lga = regiao_lga;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getMin_times() {
        return min_times;
    }

    public void setMin_times(int min_times) {
        this.min_times = min_times;
    }

    public int getMax_times() {
        return max_times;
    }

    public void setMax_times(int max_times) {
        this.max_times = max_times;
    }

    public String getEmblema() {
        return emblema;
    }

    public void setEmblema(String emblema) {
        this.emblema = emblema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_criacao_liga() {
        return data_criacao_liga;
    }

    public void setData_criacao_liga(Date data_criacao_liga) {
        this.data_criacao_liga = data_criacao_liga;
    }

    

    

    


}


   