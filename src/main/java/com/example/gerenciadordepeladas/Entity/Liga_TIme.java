package com.example.gerenciadordepeladas.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Tabela que faz a união de time e liga, já que tem relacionamento muitos para muitos
@Entity
@Table(name = "liga_time")
public class Liga_TIme {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_liga_time;

    //Chave Estrangeira da Liga
    @ManyToOne
    @JoinColumn (name = "id_liga")
    private LigaEntity ligaEntity;

    //Chave Etsrangeira do time
    @ManyToOne
    @JoinColumn (name = "id_time")
    private TimeEntity timeEntity;

    private int pontos;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int saldo_de_gols;

    public Liga_TIme() {
    }

    public Liga_TIme(Long id_liga_time, LigaEntity ligaEntity, TimeEntity timeEntity, int pontos, int vitorias,
            int derrotas, int empates, int saldo_de_gols) {
        this.id_liga_time = id_liga_time;
        this.ligaEntity = ligaEntity;
        this.timeEntity = timeEntity;
        this.pontos = pontos;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.saldo_de_gols = saldo_de_gols;
    }



    public Long getId_liga_time() {
        return id_liga_time;
    }

    public void setId_liga_time(Long id_liga_time) {
        this.id_liga_time = id_liga_time;
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

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getSaldo_de_gols() {
        return saldo_de_gols;
    }

    public void setSaldo_de_gols(int saldo_de_gols) {
        this.saldo_de_gols = saldo_de_gols;
    }

    

    


    
}
