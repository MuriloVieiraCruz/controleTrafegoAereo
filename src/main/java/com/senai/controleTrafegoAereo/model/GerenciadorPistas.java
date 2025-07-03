package com.senai.controleTrafegoAereo.model;

public class GerenciadorPistas {

    private final FilaPrioridadeAeronave[] pistas;

    public GerenciadorPistas(int numeroDePistas) {
        pistas = new FilaPrioridadeAeronave[numeroDePistas];

        for (int i = 0; i < numeroDePistas; i++) {
            pistas[i] = new FilaPrioridadeAeronave();
        }
    }

    public int selecionarPistaParaAtendimento() {
        int indiceEscolhido = -1;
        int melhorPrioridade = Integer.MIN_VALUE;
        int maiorTamanhoEmpate = -1;

        for (int i = 0; i < pistas.length; i++) {
            if (pistas[i].isEmpty()) continue;

            int prioridadeFrente = pistas[i].prioridadeDaFrente();
            int tamanho = pistas[i].getTamanho();

            if (prioridadeFrente > melhorPrioridade) {
                melhorPrioridade   = prioridadeFrente;
                maiorTamanhoEmpate = tamanho;
                indiceEscolhido = i;

            } else if (prioridadeFrente == melhorPrioridade && tamanho > maiorTamanhoEmpate) {
                maiorTamanhoEmpate = tamanho;
                indiceEscolhido = i;
            }
        }
        return indiceEscolhido;
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
