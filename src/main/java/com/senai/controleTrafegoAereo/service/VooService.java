package com.senai.controleTrafegoAereo.service;

import com.senai.controleTrafegoAereo.model.Aeronave;
import com.senai.controleTrafegoAereo.model.FilaPrioridadeAeronave;
import com.senai.controleTrafegoAereo.model.HistoricoAeronaves;
import com.senai.controleTrafegoAereo.model.NoAeronave;
import com.senai.controleTrafegoAereo.utils.BubbleSortUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VooService {

    private final FilaPrioridadeAeronave fila = new FilaPrioridadeAeronave();
    private final HistoricoAeronaves historico = new HistoricoAeronaves(100);

    public void solicitarAeronave(Aeronave aeronave) {
        aeronave.setSolicitacao(LocalDateTime.now());
        NoAeronave noAeronave = new NoAeronave(aeronave, aeronave.getPrioridade());
        fila.enqueue(noAeronave);
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
