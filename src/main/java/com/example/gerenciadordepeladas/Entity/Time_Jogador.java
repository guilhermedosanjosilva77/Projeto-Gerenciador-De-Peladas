package com.example.gerenciadordepeladas.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "time_jogador")
public class Time_Jogador {

    @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id_time_jogador;

    @ManyToOne
    @JoinColumn (name = "id_time")
    private TimeEntity timeEntity;

    @ManyToOne
    @JoinColumn (name = "id_jogador")
    private JogadorEntity jogadorEntity;

    public Time_Jogador() {
    }

    public Time_Jogador(Long id_time_jogador, TimeEntity timeEntity, JogadorEntity jogadorEntity) {
        this.id_time_jogador = id_time_jogador;
        this.timeEntity = timeEntity;
        this.jogadorEntity = jogadorEntity;
    }

    public Long getId_time_jogador() {
        return id_time_jogador;
    }

    public void setId_time_jogador(Long id_time_jogador) {
        this.id_time_jogador = id_time_jogador;
    }

    public TimeEntity getTimeEntity() {
        return timeEntity;
    }

    public void setTimeEntity(TimeEntity timeEntity) {
        this.timeEntity = timeEntity;
    }

    public JogadorEntity getJogadorEntity() {
        return jogadorEntity;
    }

    public void setJogadorEntity(JogadorEntity jogadorEntity) {
        this.jogadorEntity = jogadorEntity;
    }

    
    
}
