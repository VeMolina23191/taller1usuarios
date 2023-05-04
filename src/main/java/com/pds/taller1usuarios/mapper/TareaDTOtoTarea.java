package com.pds.taller1usuarios.mapper;

import com.pds.taller1usuarios.persistence.entity.Tarea;
import com.pds.taller1usuarios.services.dto.TareaDTO;
import org.springframework.stereotype.Component;

@Component
public class TareaDTOtoTarea implements IMapper<TareaDTO, Tarea>{
    @Override
    public Tarea mapper(TareaDTO in){
        Tarea tarea = new Tarea();
        tarea.setNombre_tarea(in.getNombre());
        return tarea;
    }
}
