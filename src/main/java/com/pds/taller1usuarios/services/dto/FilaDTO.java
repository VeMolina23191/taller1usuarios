package com.pds.taller1usuarios.services.dto;
import com.pds.taller1usuarios.persistence.entity.Tarea;
import lombok.Data;

@Data
public class FilaDTO {
    private Long id_fila;
    private int duracion;
    private Tarea tarea;
}
