package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.persistence.entity.Fila;
import com.pds.taller1usuarios.services.dto.FilaDTO;

import java.util.List;

public interface FilaService {

    //Crear fila
    Fila createFila(Fila fila);

    //Listar filas
    List<Fila> findAll();

    //Listar fila por id
    Fila findById(Long id_fila);

    //Actualizar fila
    Fila updateFila(Fila fila);

    //Eliminar fila
    void deleteFila(Long id_fila);

}
