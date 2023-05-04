package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.exceptions.TareaNotFoundException;
import com.pds.taller1usuarios.mapper.TareaDTOtoTarea;
import com.pds.taller1usuarios.persistence.entity.Tarea;
import com.pds.taller1usuarios.repository.TareaRepository;
import com.pds.taller1usuarios.services.dto.TareaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;
    private final TareaDTOtoTarea tareaDTOtoTarea;

    //Crear tarea
    @Override
    public Tarea createTarea (TareaDTO tarea) { return tareaRepository.save(tareaDTOtoTarea.mapper(tarea)); }

    //Listar tareas
    @Override
    public List<Tarea> findAll() { return tareaRepository.findAll(); }

    //Listar tarea por id
    @Override
    public Tarea findById(Long id_tarea) {
        Optional<Tarea> tarea = tareaRepository.findById(id_tarea);
        if (tarea.isPresent()){
            return tarea.get();
        }else{
            throw new TareaNotFoundException("No se encontro la tarea " + id_tarea);
        }
    }

    //Actualizar tarea
    @Override
    public Tarea updateTarea(Tarea tarea) {
        Tarea updatedTarea = tareaRepository.save(tarea);
        return updatedTarea;
    }

    //Eliminar tarea
    @Override
    public void deleteTarea(Long id_tarea){
        tareaRepository.deleteById(id_tarea);
    }

}
