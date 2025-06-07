package com.senai.controleTrafegoAereo.service;

import com.senai.controleTrafegoAereo.model.Aeronave;
import com.senai.controleTrafegoAereo.model.FilaPrioridade;
import com.senai.controleTrafegoAereo.model.HistoricoAeronaves;
import com.senai.controleTrafegoAereo.model.No;
import com.senai.controleTrafegoAereo.utils.BubbleSortUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VooService {

    private final FilaPrioridade fila = new FilaPrioridade();
    private final HistoricoAeronaves historico = new HistoricoAeronaves(100);

    public void solicitarAeronave(Aeronave aeronave) {
        aeronave.setSolicitacao(LocalDateTime.now());
        No no = new No(aeronave, aeronave.getPrioridade());
        fila.enqueue(no);
    }

    public Aeronave atenderAeronave() {
        Aeronave aeronave = fila.dequeue();

        if (aeronave != null) {
            aeronave.setAtendimento(LocalDateTime.now());
            historico.adicionar(aeronave);
        }

        return aeronave;
    }

    public Aeronave[] gerarRelatorioOrdenado() {
        Aeronave[] copia = historico.getTodos();
        BubbleSortUtil.ordenarPorTempoEspera(copia, historico.getTamanho());
        return copia;
    }


}
