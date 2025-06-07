package com.senai.controleTrafegoAereo.model;

public class HistoricoAeronaves {

    private Aeronave[] aeronaves;
    private int tamanho;

    public HistoricoAeronaves(int capacidadeInicial) {
        this.aeronaves = new Aeronave[capacidadeInicial];
        this.tamanho = 0;
    }

    public void adicionar(Aeronave aeronave) {
        if (tamanho >= aeronaves.length) {
            redimensionar();
        }
        aeronaves[tamanho++] = aeronave;
    }

    private void redimensionar() {
        Aeronave[] novo = new Aeronave[aeronaves.length * 2];
        System.arraycopy(aeronaves, 0, novo, 0, aeronaves.length);
        aeronaves = novo;
    }

    public Aeronave[] getTodos() {
        Aeronave[] copia = new Aeronave[tamanho];
        System.arraycopy(aeronaves, 0, copia, 0, tamanho);

        return copia;
    }

    public int getTamanho() {
        return tamanho;
    }
}
