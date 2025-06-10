package com.senai.controleTrafegoAereo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity(name = "Aeronave")
@Table(name = "tb_aeronave")
public class Aeronave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @NotBlank(message = "O tipo da aeronave é obrigatório")
    private String tipo;

    @NotNull(message = "É obrigatório informar uma prioridade")
    private Integer prioridade;
    private LocalDateTime solicitacao;
    private LocalDateTime atendimento;

    public Duration getTempoEspera() {
        if (atendimento != null) {
            return Duration.between(solicitacao, atendimento);
        }
        return Duration.ZERO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(LocalDateTime solicitacao) {
        this.solicitacao = solicitacao;
    }

    public LocalDateTime getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(LocalDateTime atendimento) {
        this.atendimento = atendimento;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Aeronave() {
    }

    public Aeronave(String id, String tipo, Integer prioridade, LocalDateTime solicitacao, LocalDateTime atendimento) {
        this.id = id;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.solicitacao = solicitacao;
        this.atendimento = atendimento;
    }
}
