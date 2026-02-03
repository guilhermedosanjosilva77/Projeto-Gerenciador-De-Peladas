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
    
    @OneToMany (mappedBy = "timeEntity")
    private List<Liga_TIme> ligatimes;

    //UM time pode ter vários jogadores
    @OneToMany (mappedBy = "timeEntity")
    private List<Time_Jogador> timejogador;

    //tabela estatistica jogador
    @OneToMany (mappedBy = "timeEntity")
    private List <Estatisitca_Jogador> estatisitca_Jogador;

    //tabela estatistica time
    @OneToMany (mappedBy = "timeEntity")
    private List <Estatistica_time> estatistica_time;

    private String nomeTime;
    private String regiao;

    //ATencao
    private String emblema;
    
    private Date data_criacao_time;

    public TimeEntity() {
    }

    public TimeEntity(Long id_time, List<Liga_TIme> ligatimes, List<Time_Jogador> timejogador,
            List<Estatisitca_Jogador> estatisitca_Jogador, List<Estatistica_time> estatistica_time, String nomeTime,
            String regiao, String emblema, Date data_criacao_time) {
        this.id_time = id_time;
        this.ligatimes = ligatimes;
        this.timejogador = timejogador;
        this.estatisitca_Jogador = estatisitca_Jogador;
        this.estatistica_time = estatistica_time;
        this.nomeTime = nomeTime;
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

    public List<Liga_TIme> getLigatimes() {
        return ligatimes;
    }

    public void setLigatimes(List<Liga_TIme> ligatimes) {
        this.ligatimes = ligatimes;
    }

    public List<Time_Jogador> getTimejogador() {
        return timejogador;
    }

    public void setTimejogador(List<Time_Jogador> timejogador) {
        this.timejogador = timejogador;
    }

    public List<Estatisitca_Jogador> getEstatisitca_Jogador() {
        return estatisitca_Jogador;
    }

    public void setEstatisitca_Jogador(List<Estatisitca_Jogador> estatisitca_Jogador) {
        this.estatisitca_Jogador = estatisitca_Jogador;
    }

    public List<Estatistica_time> getEstatistica_time() {
        return estatistica_time;
    }

    public void setEstatistica_time(List<Estatistica_time> estatistica_time) {
        this.estatistica_time = estatistica_time;
    }

    public String getNome_time() {
        return nomeTime;
    }

    public void setNome_time(String nome_time) {
        this.nomeTime = nome_time;
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