package com.ceco.apirest.casacambio.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "tipocambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double valorCambio;
    private String Pais;
}
