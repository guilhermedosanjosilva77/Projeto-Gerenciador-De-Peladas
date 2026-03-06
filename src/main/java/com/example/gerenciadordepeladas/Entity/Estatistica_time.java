package com.example.gerenciadordepeladas.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "estatitica_time")
public class Estatistica_time {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_estatistica_time;

    //FK id_time
    @OneToOne   
    @JoinColumn (name = "id_time")
    private TimeEntity timeEntity;

    //FK id_liga
    @ManyToOne
    @JoinColumn (name = "id_liga")
    private LigaEntity ligaEntity;

    private int gols_pro;
    private int gols_contra;
    private int vitoria;
    private int derrota;
    private int empate;
    private int saldoGols;

    public Estatistica_time() {
    }

    public Estatistica_time(Long id_estatistica_time, TimeEntity timeEntity, LigaEntity ligaEntity,
            int gols_pro, int gols_contra, int vitoria, int derrota, int empate, int saldoGols) {
        this.id_estatistica_time = id_estatistica_time;
        this.timeEntity = timeEntity;
        this.ligaEntity = ligaEntity;
        this.gols_pro = gols_pro;
        this.gols_contra = gols_contra;
        this.vitoria = vitoria;
        this.derrota = derrota;
        this.empate = empate;
        this.saldoGols = saldoGols;
    }

    public Long getId_estatistica_time() {
        return id_estatistica_time;
    }

    public void setId_estatistica_time(Long id_estatistica_time) {
        this.id_estatistica_time = id_estatistica_time;
    }

    public TimeEntity getTimeEntity() {
        return timeEntity;
    }

    public void setTimeEntity(TimeEntity timeEntity) {
        this.timeEntity = timeEntity;
    }

    public LigaEntity getLigaEntity() {
        return ligaEntity;
    }

    public void setLigaEntity(LigaEntity ligaEntity) {
        this.ligaEntity = ligaEntity;
    }

    public int getGols_pro() {
        return gols_pro;
    }

    public void setGols_pro(int gols_pro) {
        this.gols_pro = gols_pro;
    }

    public int getGols_contra() {
        return gols_contra;
    }

    public void setGols_contra(int gols_contra) {
        this.gols_contra = gols_contra;
    }

    public int getVitoria() {
        return vitoria;
    }

    public void setVitoria(int vitoria) {
        this.vitoria = vitoria;
    }

    public int getDerrota() {
        return derrota;
    }

    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }

    public int getEmpate() {
        return empate;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
    }

}