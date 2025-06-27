package com.senai.controleTrafegoAereo.model;

public class GerenciadorPistas {

    private final FilaPrioridadeAeronave[] pistas;

    public GerenciadorPistas(int numeroDePistas) {
        pistas = new FilaPrioridadeAeronave[numeroDePistas];

        for (int i = 0; i < numeroDePistas; i++) {
            pistas[i] = new FilaPrioridadeAeronave();
        }
    }

    public int pistaMaisCheia() {
        int indiceMaisCheia = -1;
        int maiorTamanho   = 0;

        for (int i = 0; i < pistas.length; i++) {
            int tamanho = pistas[i].getTamanho();
            if (tamanho > maiorTamanho) {
                maiorTamanho   = tamanho;
                indiceMaisCheia = i;
            }
        }
        return indiceMaisCheia;
    }

    public int escolherMelhorPista(Aeronave aeronave) {
        int prioridadeAeronave = aeronave.getPrioridade();
        int melhorIndice = 0;
        int menorQuantidadeMaisPrioritaria = Integer.MAX_VALUE;

        for (int i = 0; i < pistas.length; i++) {
            int contarMaisPrioritarias = pistas[i].contarAeronavesNaFrente(prioridadeAeronave);
            if (contarMaisPrioritarias < menorQuantidadeMaisPrioritaria) {
                menorQuantidadeMaisPrioritaria = contarMaisPrioritarias;
                melhorIndice = i;
            }
        }

        return melhorIndice;
    }

    public void adicionarAeronaveNaMelhorPista(Aeronave aeronave) {
        int pistaEscolhida = escolherMelhorPista(aeronave);
        NoAeronave no = new NoAeronave(aeronave, aeronave.getPrioridade());
        pistas[pistaEscolhida].enqueue(no);
    }

    public Aeronave atenderDaPista(int indicePista) {
        return pistas[indicePista].dequeue();
    }

    public FilaPrioridadeAeronave[] getPistas() {
        return pistas;
    }
}
