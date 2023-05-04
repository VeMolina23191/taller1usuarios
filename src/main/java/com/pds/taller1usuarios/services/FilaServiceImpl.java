package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.exceptions.FilaNotFoundException;
import com.pds.taller1usuarios.mapper.FilaDTOtoTarea;
import com.pds.taller1usuarios.persistence.entity.Fila;
import com.pds.taller1usuarios.repository.FilaRepository;
import com.pds.taller1usuarios.services.dto.FilaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilaServiceImpl implements FilaService {

    private final FilaRepository filaRepository;
    private final FilaDTOtoTarea filaDTOtoTarea;

    //Crear fila
    @Override
    public Fila createFila (Fila fila) {
        return filaRepository.save(fila); }


    //Listar filas
    @Override
    public List<Fila> findAll() { return filaRepository.findAll(); }

    //Listar fila por id
    @Override
    public Fila findById(Long id_fila) {
        Optional<Fila> fila = filaRepository.findById(id_fila);
        if (fila.isPresent()){
            return fila.get();
        }else{
            throw new FilaNotFoundException("No se encontro la fila " + id_fila);
        }
    }

    //Actualizar fila
    @Override
    public Fila updateFila(Fila fila) {
        Fila updatedFila = filaRepository.save(fila);
        return updatedFila;
    }

    //Eliminar fila
    @Override
    public void deleteFila(Long id_fila){
        filaRepository.deleteById(id_fila);
    }

}
