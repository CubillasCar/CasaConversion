package com.ceco.apirest.casacambio.exception;


public class ModelNotFoundException extends RuntimeException{

    public ModelNotFoundException(String message) {
        super(message);
    }
}
