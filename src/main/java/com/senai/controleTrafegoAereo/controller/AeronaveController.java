package com.senai.controleTrafegoAereo.controller;

import com.senai.controleTrafegoAereo.model.Aeronave;
import com.senai.controleTrafegoAereo.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aeronaves")
public class AeronaveController {

    @Autowired
    private VooService service;

    @PostMapping("/solicitar")
    public ResponseEntity<?> solicitar(@RequestBody Aeronave aeronave) {
        service.solicitarAeronave(aeronave);
        return ResponseEntity.ok("Solicitação registrada");
    }

    @PostMapping("/atender")
    public ResponseEntity<Aeronave> atender() {
        return ResponseEntity.ok(service.atenderAeronave());
    }

    @GetMapping("/relatorio")
    public ResponseEntity<Aeronave[]> relatorio() {
        return ResponseEntity.ok(service.gerarRelatorioOrdenado());
    }
}
