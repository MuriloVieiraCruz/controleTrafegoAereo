package com.senai.controleTrafegoAereo.model;

public class No {

    private Aeronave valor;
    private int prioridade;
    private No proximo;

    public No(Aeronave valor, int prioridade) {
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

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
