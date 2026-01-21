package com.example.gerenciadordepeladas.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "estatitica_time")
public class Estatistica_time {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_estatistica_time;

    //FK id_time
    @ManyToOne
    @JoinColumn (name = "time")
    private TimeEntity timeEntity;

    //FK id_liga
    @ManyToOne
    @JoinColumn (name = "liga")
    private LigaEntity ligaEntity;

    private int gols_pro;
    private int gols_contra;

    public Estatistica_time() {
    }

    public Estatistica_time(Long id_estatistica_time, TimeEntity timeEntity, LigaEntity ligaEntity, int gols_pro,
            int gols_contra) {
        this.id_estatistica_time = id_estatistica_time;
        this.timeEntity = timeEntity;
        this.ligaEntity = ligaEntity;
        this.gols_pro = gols_pro;
        this.gols_contra = gols_contra;
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
    
    
    
}
