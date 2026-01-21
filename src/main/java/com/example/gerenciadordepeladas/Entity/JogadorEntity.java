package com.example.gerenciadordepeladas.Entity;

import java.sql.Date;
import java.util.List;

import com.example.gerenciadordepeladas.Enums.EnumPosicao;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogador")
public class JogadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_jogador;

    // Relacionamento: um jogador pode ter vários vínculos com times
    @OneToMany (mappedBy = "jogador")
    private List<Time_Jogador> timejogador;

    //Relacionamento tabela estatistica jogador
    @OneToMany (mappedBy = "jogador")
    private List<Estatisitca_Jogador> estatisitca_Jogador;

    private String nome;

    //Atenção
    @Enumerated (EnumType.STRING)
    private EnumPosicao posicao;

    //Atenção
    private String foto;
    private String status;
    private Date data_criaçao;

    public JogadorEntity() {
    }

    public JogadorEntity(Long id_jogador, String nome, EnumPosicao posicao, String foto, String status, Date data_criaçao) {
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

    public EnumPosicao getPosicao() {
        return posicao;
    }

    public void setPosicao(EnumPosicao posicao) {
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
