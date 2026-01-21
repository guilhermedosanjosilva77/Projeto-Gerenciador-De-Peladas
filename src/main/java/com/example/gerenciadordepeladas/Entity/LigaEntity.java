package com.example.gerenciadordepeladas.Entity;

import java.util.Date;
import java.util.List;

import com.example.gerenciadordepeladas.Enums.EnumFormato;
import com.example.gerenciadordepeladas.Enums.EnumModalidade;
import com.example.gerenciadordepeladas.Enums.EnumStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "liga")
public class LigaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_liga;

    //tabela liga_time relacionamento muitos para muitos
    @OneToMany (mappedBy = "liga")
    private List<Liga_TIme> ligatimes;

    //tabela estatistica de jogadores
    @OneToMany (mappedBy = "liga")  
    private List<Estatisitca_Jogador> estatisitca_Jogador;

    //tabela estatistica time na liga 
    @OneToMany (mappedBy = "liga")
    private List<Estatistica_time> estatistica_time;

    private String nome_liga;
    private String regiao_lga;

    @Enumerated (EnumType.STRING)
    private EnumModalidade modalidade;

    
    @Enumerated (EnumType.STRING)
    private EnumFormato formato;

    private int min_times;
    private int max_times;

    //Atencao
    private String emblema;

    @Enumerated (EnumType.STRING)
    private EnumStatus status;

    private Date data_criacao_liga;

    public LigaEntity() {
    }

    public LigaEntity(Long id_liga, List<Liga_TIme> ligatimes, List<Estatisitca_Jogador> estatisitca_Jogador,
            List<Estatistica_time> estatistica_time, String nome_liga, String regiao_lga, EnumModalidade modalidade,
            EnumFormato formato, int min_times, int max_times, String emblema, EnumStatus status,
            Date data_criacao_liga) {
        this.id_liga = id_liga;
        this.ligatimes = ligatimes;
        this.estatisitca_Jogador = estatisitca_Jogador;
        this.estatistica_time = estatistica_time;
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

    public List<Liga_TIme> getLigatimes() {
        return ligatimes;
    }

    public void setLigatimes(List<Liga_TIme> ligatimes) {
        this.ligatimes = ligatimes;
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

    public EnumModalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(EnumModalidade modalidade) {
        this.modalidade = modalidade;
    }

    public EnumFormato getFormato() {
        return formato;
    }

    public void setFormato(EnumFormato formato) {
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

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public Date getData_criacao_liga() {
        return data_criacao_liga;
    }

    public void setData_criacao_liga(Date data_criacao_liga) {
        this.data_criacao_liga = data_criacao_liga;
    }

    

}