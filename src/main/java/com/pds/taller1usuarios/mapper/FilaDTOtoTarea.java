package com.pds.taller1usuarios.mapper;

import com.pds.taller1usuarios.persistence.entity.Fila;
import com.pds.taller1usuarios.services.dto.FilaDTO;
import org.springframework.stereotype.Component;

@Component
public class FilaDTOtoTarea implements IMapper<FilaDTO, Fila>{


    @Override
    public Fila mapper(FilaDTO in){
        Fila fila = new Fila();
        fila.setDuracion(in.getDuracion());
        fila.setTarea(in.getTarea());
        return fila;
    }

}
