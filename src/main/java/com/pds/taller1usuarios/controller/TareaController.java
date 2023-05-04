package com.pds.taller1usuarios.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pds.taller1usuarios.exceptions.TareaNotFoundException;
import com.pds.taller1usuarios.persistence.entity.Tarea;
import com.pds.taller1usuarios.services.TareaService;
import com.pds.taller1usuarios.services.dto.TareaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;

    //Crear tarea
    @PostMapping
    public Tarea createTarea(@RequestBody TareaDTO tarea){ return tareaService.createTarea(tarea); }

    //Listar tareas
    @GetMapping
    public List<Tarea> findAll() { return tareaService.findAll(); }

    //Listar tarea por id
    @GetMapping("/id_tarea/{id_tarea}")
    public Tarea findById(@PathVariable("id_tarea") Long id_tarea){
        return tareaService.findById(id_tarea);
    }

    //Actualizar tarea
    @PatchMapping("/{id_tarea}")
    public Tarea updateTarea(@PathVariable("id_tarea") Long id, @RequestBody Tarea newTarea) {
        Tarea oldTarea = tareaService.findById(id);
        if (oldTarea == null) {
            throw new TareaNotFoundException("No se encontró la tarea");
        }else{
            oldTarea.setNombre_tarea(newTarea.getNombre_tarea());
            return tareaService.updateTarea(oldTarea);
        }

    }

    //Eliminar tarea
    @DeleteMapping("/{id_tarea}")
    public void deleteTarea(@PathVariable("id_tarea") Long id_tarea){
        tareaService.deleteTarea(id_tarea);
    }


}
