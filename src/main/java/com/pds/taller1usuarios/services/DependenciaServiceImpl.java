package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.persistence.entity.Dependencia;
import com.pds.taller1usuarios.repository.DependenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DependenciaServiceImpl implements DependenciaService{

    private final DependenciaRepository dependenciaRepository;

    @Override
    public List<Dependencia> findAll() {return dependenciaRepository.findAll();}

    @Override
    public Dependencia findById(Long id) {
        Dependencia dependencia = this.dependenciaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Dependencia no encontrada"));
        return dependencia;
    }

}
