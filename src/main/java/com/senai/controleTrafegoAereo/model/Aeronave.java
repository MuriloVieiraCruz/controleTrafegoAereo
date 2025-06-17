package com.senai.controleTrafegoAereo.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Aeronave {

    private String id;
    private String tipo;
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
}
