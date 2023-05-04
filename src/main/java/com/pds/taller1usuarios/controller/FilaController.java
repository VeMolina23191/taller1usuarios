package com.pds.taller1usuarios.controller;

import com.pds.taller1usuarios.exceptions.FilaNotFoundException;
import com.pds.taller1usuarios.exceptions.TareaNotFoundException;
import com.pds.taller1usuarios.mapper.TareaDTOtoTarea;
import com.pds.taller1usuarios.persistence.entity.Fila;
import com.pds.taller1usuarios.persistence.entity.Tarea;
import com.pds.taller1usuarios.services.FilaService;
import com.pds.taller1usuarios.services.TareaService;
import com.pds.taller1usuarios.services.dto.FilaDTO;
import com.pds.taller1usuarios.services.dto.TareaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fila")
@RequiredArgsConstructor
public class FilaController {

    private final FilaService filaService;
    private final TareaService tareaService;

    private final TareaDTOtoTarea tareaDTOtoTarea;

    //Crear fila
    @PostMapping
    public Fila createTarea(@RequestBody Fila filaDTO){
        //Validar que la duración sea entre 1 y 60
        if(filaDTO.getDuracion() < 1 || filaDTO.getDuracion() > 60){
            throw new FilaNotFoundException("La duracion debe estar en un rango entre 1 y 60");
        }else{
            //Buscando la tarea
            Tarea tarea = tareaService.findById(filaDTO.getTarea().getId_tarea());
            filaDTO.setTarea(tarea);
            System.out.println("tarea " + filaDTO.getTarea().getNombre_tarea());
            return filaService.createFila(filaDTO);
        }
        }

    //Listar filas
    @GetMapping
    public List<Fila> findAll() { return filaService.findAll(); }

    //Listar filas por id
    @GetMapping("/id_fila/{id_fila}")
    public Fila findById(@PathVariable("id_fila") Long id_fila){
        return filaService.findById(id_fila);
    }

    //Actualizar fila

    //Nota: Validar que, si cambia de tarea, la tarea este disponible

    @PatchMapping("/{id_fila}")
    public Fila updateFila(@PathVariable("id_fila") Long id, @RequestBody FilaDTO newFila) {
        Fila oldFila = filaService.findById(id);
        if (oldFila == null) {
            throw new TareaNotFoundException("No se encontró la tarea");
        }else{
            oldFila.setDuracion(newFila.getDuracion());
            oldFila.setTarea(newFila.getTarea());
            return filaService.updateFila(oldFila);
        }

    }


    //Eliminar fila
    @DeleteMapping("/{id_fila}")
    public void deleteFila(@PathVariable("id_fila") Long id_fila){
        filaService.deleteFila(id_fila);
    }


}
