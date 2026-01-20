package com.example.gerenciadordepeladas.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogador")
public class JogadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_jogador;
    private String nome;

    //Atenção
    private String posicao;

    //Atenção
    private String foto;
    private String status;
    private Date data_criaçao;

    public JogadorEntity() {
    }

    public JogadorEntity(Long id_jogador, String nome, String posicao, String foto, String status, Date data_criaçao) {
        this.id_jogador = id_jogador;
        this.nome = nome;
        this.posicao = posicao;
        this.foto = foto;
        this.status = status;
        this.data_criaçao = data_criaçao;
    }

    public Long getId_jogador() {
        return id_jogador;
    }

    public void setId_jogador(Long id_jogador) {
        this.id_jogador = id_jogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_criaçao() {
        return data_criaçao;
    }

    public void setData_criaçao(Date data_criaçao) {
        this.data_criaçao = data_criaçao;
    }

    

    

    
}
