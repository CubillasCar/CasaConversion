package com.ceco.apirest.casacambio.controller;

import com.ceco.apirest.casacambio.dto.ConversionRequest;
import com.ceco.apirest.casacambio.dto.GenericResponse;
import com.ceco.apirest.casacambio.service.ConversionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class ConversionController {

    private static Logger logger = LoggerFactory.getLogger(ConversionController.class);

    private final ConversionService conversionService;

    @PostMapping("/conversion")
    public ResponseEntity<GenericResponse<ConversionRequest>> convertir(@Valid @RequestBody ConversionRequest request) throws Exception{

        logger.info("ConversionController - Inicio: convertir");

        Double montoConvertido = conversionService.conversion(request);
        logger.info("montoConvertido: " + montoConvertido);
        request.setMontoConvertido(montoConvertido);

        logger.info("ConversionController - Fin: convertir");
       return ResponseEntity.ok(new GenericResponse<>(201,"succes", Arrays.asList(request)));
    }

}
