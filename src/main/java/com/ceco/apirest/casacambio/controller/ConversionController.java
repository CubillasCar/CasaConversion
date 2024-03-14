package com.ceco.apirest.casacambio.controller;

import com.ceco.apirest.casacambio.dto.ConversionRequest;
import com.ceco.apirest.casacambio.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @PostMapping("/conversion")
    public ConversionRequest convertir(@RequestBody ConversionRequest request){
        Double montoConvertido = conversionService.conversion(request);
        request.setMontoConvertido(montoConvertido);
       return request;
    }

}
