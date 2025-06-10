package com.senai.controleTrafegoAereo.model;

import com.senai.controleTrafegoAereo.model.enums.Tipo;
import jakarta.persistence.*;

@Entity(name = "Pista")
@Table(name = "tb_pista")
public class Pista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Pista() {
    }

    public Pista(Integer id, Tipo tipo) {
        this.id = id;
        this.tipo = tipo;
    }
}
