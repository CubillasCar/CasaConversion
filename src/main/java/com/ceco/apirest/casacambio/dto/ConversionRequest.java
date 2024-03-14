package com.ceco.apirest.casacambio.dto;

import lombok.Data;

@Data
public class ConversionRequest {

    private double monto;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;
    private double montoConvertido;
}
