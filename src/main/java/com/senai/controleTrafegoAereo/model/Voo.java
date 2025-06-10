package com.senai.controleTrafegoAereo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Voo")
@Table(name = "tb_voo")
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Aeronave aeronave;

    private int prioridade;

    private Aeroporto aeroportoChegada;

    private Aeroporto aeroportoSaida;

    private LocalDateTime dataEsperadaChegada;

    private LocalDateTime dataEsperadaSaida;

    private LocalDateTime dataRealChegada;

    private LocalDateTime dataRealSaida;

    public Voo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Aeroporto getAeroportoChegada() {
        return aeroportoChegada;
    }

    public void setAeroportoChegada(Aeroporto aeroportoChegada) {
        this.aeroportoChegada = aeroportoChegada;
    }

    public Aeroporto getAeroportoSaida() {
        return aeroportoSaida;
    }

    public void setAeroportoSaida(Aeroporto aeroportoSaida) {
        this.aeroportoSaida = aeroportoSaida;
    }

    public LocalDateTime getDataEsperadaChegada() {
        return dataEsperadaChegada;
    }

    public void setDataEsperadaChegada(LocalDateTime dataEsperadaChegada) {
        this.dataEsperadaChegada = dataEsperadaChegada;
    }

    public LocalDateTime getDataEsperadaSaida() {
        return dataEsperadaSaida;
    }

    public void setDataEsperadaSaida(LocalDateTime dataEsperadaSaida) {
        this.dataEsperadaSaida = dataEsperadaSaida;
    }

    public LocalDateTime getDataRealChegada() {
        return dataRealChegada;
    }

    public void setDataRealChegada(LocalDateTime dataRealChegada) {
        this.dataRealChegada = dataRealChegada;
    }

    public LocalDateTime getDataRealSaida() {
        return dataRealSaida;
    }

    public void setDataRealSaida(LocalDateTime dataRealSaida) {
        this.dataRealSaida = dataRealSaida;
    }
}
