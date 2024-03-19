package com.ceco.apirest.casacambio.service;

import com.ceco.apirest.casacambio.dto.ConversionRequest;
import com.ceco.apirest.casacambio.model.Conversion;
import com.ceco.apirest.casacambio.repository.ConversionRepository;
import com.ceco.apirest.casacambio.repository.TipoCambioRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConversionService {

    private static Logger logger = LoggerFactory.getLogger(ConversionService.class);

    private final ConversionRepository conversionRepository;
    private final TipoCambioRepository tipoCambioRepository;


    public Double conversion(ConversionRequest request){

        logger.info("ConversionService - Inicio: conversion");


        Double tipoCambio = obtenerTipoCambio(request.getMonedaDestino());
        logger.info("tipoCambio: " + tipoCambio);

        if(tipoCambio == null){
            throw new RuntimeException("Tipo de cambio no encontrado para la moneda destino.");
        }

        Double  montoConvertido = request.getMonto()*tipoCambio;
        logger.info("montoConvertido: " + montoConvertido);

        Conversion conversion = new Conversion(null,request.getMonto(),request.getMonedaOrigen(),request.getMonedaDestino());
        logger.info("conversion: " + conversion);

        request.setTipoCambio(tipoCambio);
        conversionRepository.save(conversion);
        request.setId(conversion.getId());

        logger.info("ConversionService - Fin: conversion");
        return montoConvertido;
    }

   private Double obtenerTipoCambio(String monedaDestino){
        return tipoCambioRepository.findTipoCambioBy(monedaDestino);
   }

}
