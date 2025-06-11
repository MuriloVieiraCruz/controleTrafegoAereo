package com.senai.controleTrafegoAereo.model;

public class NoAeronave {

    private Aeronave valor;
    private int prioridade;
    private NoAeronave proximo;

    public NoAeronave(Aeronave valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
    }

    public Aeronave getValor() {
        return valor;
    }

    public void setValor(Aeronave valor) {
        this.valor = valor;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public NoAeronave getProximo() {
        return proximo;
    }

    public void setProximo(NoAeronave proximo) {
        this.proximo = proximo;
    }
}
