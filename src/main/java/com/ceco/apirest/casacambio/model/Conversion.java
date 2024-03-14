package com.ceco.apirest.casacambio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conversion")
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double monto;
    private String monedaOrigen;
    private String monedaDestino;


}
