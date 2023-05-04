package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.persistence.entity.Dependencia;

import java.util.List;

public interface DependenciaService {

    List<Dependencia> findAll();

    Dependencia findById(Long id);
}
