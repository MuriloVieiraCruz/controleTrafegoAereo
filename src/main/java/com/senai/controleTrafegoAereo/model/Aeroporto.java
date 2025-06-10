package com.senai.controleTrafegoAereo.model;

import com.senai.controleTrafegoAereo.model.enums.TipoAeronave;
import jakarta.persistence.*;

@Entity(name = "Aeroporto")
@Table(name = "tb_aeroporto")
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    private TipoAeronave tipo;
}
