package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.persistence.entity.Tarea;
import com.pds.taller1usuarios.services.dto.TareaDTO;

import java.util.List;

public interface TareaService {

    //Crear tarea
    Tarea createTarea(TareaDTO tarea);

    //Listar tareas
    List<Tarea> findAll();

    //Listar tarea por id
    Tarea findById(Long id_tarea);

    //Actualizar tarea
    Tarea updateTarea(Tarea tarea);

    //Eliminar tarea
    void deleteTarea(Long id_tarea);
}
