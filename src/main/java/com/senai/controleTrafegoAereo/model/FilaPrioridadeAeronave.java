package com.senai.controleTrafegoAereo.model;

public class FilaPrioridadeAeronave {

    private NoAeronave inicio;
    private NoAeronave fim;
    private int tamanho = 0;

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public void enqueue(NoAeronave atual) {

        if (isEmpty()) {
            this.inicio = atual;
            this.fim = atual;
        } else {

            if (atual.getPrioridade() >= this.inicio.getPrioridade()) {
                atual.setProximo(inicio);
                this.inicio = atual;
            } else {
                if (atual.getPrioridade() <= this.fim.getPrioridade()) {
                    this.fim.setProximo(atual);
                    this.fim = atual;
                } else {
                    NoAeronave auxiliar = inicio;
                    while(auxiliar.getProximo() != null && auxiliar.getProximo().getPrioridade() > atual.getPrioridade()) {
                        auxiliar = auxiliar.getProximo();
                    }

                    atual.setProximo(auxiliar.getProximo());
                    auxiliar.setProximo(atual);
                }
            }
        }

        tamanho++;
    }

    public Aeronave dequeue() {
        if (!isEmpty()) {
            Aeronave elemento = inicio.getValor();
            inicio = inicio.getProximo();
            if (inicio == null) {
                fim = null;
            }
            tamanho--;
            return elemento;
        }
        return null;
    }

    public String view() {
        StringBuilder valores = new StringBuilder();
        NoAeronave aux = inicio;

        while(aux != null) {
            valores.append(aux.getValor().toString());
            aux = aux.getProximo();
        }

        return valores.toString();
    }

    public int contarAeronavesNaFrente(int prioridadeReferencia) {
        int count = 0;
        NoAeronave atual = inicio;

        while (atual != null) {
            if (atual.getPrioridade() > prioridadeReferencia) {
                count++;
            } else if (atual.getPrioridade() == prioridadeReferencia) {
                count++;
            }
            atual = atual.getProximo();
        }

        return count;
    }

    public NoAeronave getInicio() {
        return inicio;
    }

    public NoAeronave getFim() {
        return fim;
    }

    public int getTamanho() {
        return tamanho;
    }
}
