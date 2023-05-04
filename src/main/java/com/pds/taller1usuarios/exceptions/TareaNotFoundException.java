package com.pds.taller1usuarios.exceptions;
public class TareaNotFoundException extends RuntimeException{
    public TareaNotFoundException(String mensaje){
        super(mensaje);
    }

}
