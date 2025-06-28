package com.senai.controleTrafegoAereo.controller;

import com.senai.controleTrafegoAereo.model.Aeronave;
import com.senai.controleTrafegoAereo.model.FilaPrioridadeAeronave;
import com.senai.controleTrafegoAereo.service.AeronaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/aeronaves")
public class AeronaveController {

    @Autowired
    private AeronaveService service;

    @PostMapping("/solicitar")
    public ResponseEntity<?> solicitar(@RequestBody Aeronave aeronave) {
        service.solicitarAeronave(aeronave);
        return ResponseEntity.ok("Solicitação registrada");
    }

    @PostMapping("/atender")
    public ResponseEntity<?> atenderPorPista() {
        Aeronave aeronave = service.atenderAeronavePorPista();
        if (aeronave == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma aeronave na pista ");
        }
        return ResponseEntity.ok(aeronave);
    }

    @GetMapping("/pistas")
    public ResponseEntity<?> visualizarPistas() {
        FilaPrioridadeAeronave[] pistas = service.visualizarPistas();
        return ResponseEntity.ok(pistas);
    }

    @GetMapping("/relatorio")
    public ResponseEntity<Aeronave[]> relatorio() {
        return ResponseEntity.ok(service.gerarRelatorioOrdenado());
    }
}
