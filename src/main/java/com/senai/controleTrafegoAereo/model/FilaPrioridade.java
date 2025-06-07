package com.senai.controleTrafegoAereo.model;

public class FilaPrioridade {

    private No inicio;
    private No fim;

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public void enqueue(No atual) {

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
                    No auxiliar = inicio;
                    while(auxiliar.getProximo() != null && auxiliar.getProximo().getPrioridade() > atual.getPrioridade()) {
                        auxiliar = auxiliar.getProximo();
                    }

                    atual.setProximo(auxiliar.getProximo());
                    auxiliar.setProximo(atual);
                }
            }
        }
    }

    public Aeronave dequeue() {
        if (!isEmpty()) {
            Aeronave elemento = inicio.getValor();
            inicio = inicio.getProximo();
            if (inicio == null) {
                fim = null;
            }
            return elemento;
        }
        return null;
    }

    public String view() {
        StringBuilder valores = new StringBuilder();
        No aux = inicio;

        while(aux != null) {
            valores.append(aux.getValor().toString());
            aux = aux.getProximo();
        }

        return valores.toString();
    }

    public No getInicio() {
        return inicio;
    }

    public No getFim() {
        return fim;
    }
}
