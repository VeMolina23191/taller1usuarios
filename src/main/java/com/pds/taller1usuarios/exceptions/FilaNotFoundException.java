package com.pds.taller1usuarios.exceptions;

public class FilaNotFoundException extends RuntimeException {
    public FilaNotFoundException(String mensaje){
        super(mensaje);
    }
}
