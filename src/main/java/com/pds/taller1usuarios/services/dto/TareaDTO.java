package com.pds.taller1usuarios.services.dto;

import lombok.Data;

@Data
public class TareaDTO {
    private Long id_tarea;
    private String nombre;

    private FilaDTO fila;

}
