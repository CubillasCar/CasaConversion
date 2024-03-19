package com.ceco.apirest.casacambio.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConversionRequest {

    private Long id;

    @NotNull
    @DecimalMin(value = "0.1", message = "El monto debe ser mayor a 0")
    private double monto;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;
    private double montoConvertido;
}
