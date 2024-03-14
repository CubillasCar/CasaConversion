package com.ceco.apirest.casacambio.service;

import com.ceco.apirest.casacambio.dto.ConversionRequest;
import com.ceco.apirest.casacambio.model.Conversion;
import com.ceco.apirest.casacambio.repository.ConversionRepository;
import com.ceco.apirest.casacambio.repository.TipoCambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    @Autowired
    private  ConversionRepository conversionRepository;

    @Autowired
    private  TipoCambioRepository tipoCambioRepository;
    public Double conversion(ConversionRequest request){
        Double tipoCambio = obtenerTipoCambio(request.getMonedaDestino());

        if(tipoCambio == null){
            throw new RuntimeException("Tipo de cambio no encontrado para las monedas especificadas.");
        }
        Double  montoConvertido = request.getMonto()*tipoCambio;
        Conversion conversion = new Conversion(null,request.getMonto(),request.getMonedaOrigen(),request.getMonedaDestino());
        request.setTipoCambio(tipoCambio);
        conversionRepository.save(conversion);
        return montoConvertido;
    }

   private Double obtenerTipoCambio(String monedaDestino){
        return tipoCambioRepository.findTipoCambioBy(monedaDestino);
   }

}
