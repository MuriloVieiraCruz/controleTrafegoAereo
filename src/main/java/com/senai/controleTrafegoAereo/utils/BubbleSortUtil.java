package com.senai.controleTrafegoAereo.utils;

import com.senai.controleTrafegoAereo.model.Aeronave;

public class BubbleSortUtil {

    public static void ordenarPorTempoEspera(Aeronave[] vetor, int tamanho) {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (vetor[j].getTempoEspera().compareTo(vetor[j + 1].getTempoEspera()) > 0) {
                    Aeronave temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }
}
