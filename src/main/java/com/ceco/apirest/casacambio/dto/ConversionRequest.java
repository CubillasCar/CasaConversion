package com.ceco.apirest.casacambio.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ConversionRequest {

    private Long id;

    @NotNull(message = "Monto no se acepta nulo")
    @DecimalMin(value = "0.1", message = "El monto debe ser mayor a 0")
    private double monto;

    @NotNull(message = "Moneda origen no acepta nulo")
    @NotEmpty
    @Size(max = 3 , message="Moneda origen máximo 3 letras")
    private String monedaOrigen;

    @NotNull(message = "Moneda destino no acepta nulo")
    @NotEmpty
    @Size(max = 3 , message="Moneda de destino máximo 3 letras")
    private String monedaDestino;
    private double tipoCambio;
    private double montoConvertido;
}
