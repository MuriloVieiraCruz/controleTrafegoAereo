package com.senai.controleTrafegoAereo.service;

import com.senai.controleTrafegoAereo.model.*;
import com.senai.controleTrafegoAereo.utils.BubbleSortUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AeronaveService {

    private final GerenciadorPistas gerenciador = new GerenciadorPistas(3);
    private final HistoricoAeronaves historico = new HistoricoAeronaves(100);

    public void solicitarAeronave(Aeronave aeronave) {
        aeronave.setSolicitacao(LocalDateTime.now());
        gerenciador.adicionarAeronaveNaMelhorPista(aeronave);
    }

    public Aeronave atenderAeronavePorPista() {
        int pista = gerenciador.pistaMaisCheia();
        if (pista == -1) {
            return null;
        }

        Aeronave aeronave = gerenciador.atenderDaPista(pista);

        if (aeronave != null) {
            aeronave.setAtendimento(LocalDateTime.now());
            historico.adicionar(aeronave);
        }

        return aeronave;
    }

    public FilaPrioridadeAeronave[] visualizarPistas() {
        return gerenciador.getPistas();
    }

    public Aeronave[] gerarRelatorioOrdenado() {
        Aeronave[] copia = historico.getTodos();
        BubbleSortUtil.ordenarPorTempoEspera(copia, historico.getTamanho());
        return copia;
    }


}
