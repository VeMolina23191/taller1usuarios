package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.persistence.entity.Perfil;

import java.util.List;

public interface PerfilService {

    List<Perfil> findAll();
    Perfil findById(Long id);

}
