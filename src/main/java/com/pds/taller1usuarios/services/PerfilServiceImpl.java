package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.persistence.entity.Perfil;
import com.pds.taller1usuarios.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService{
    private final PerfilRepository perfilRepository;

    @Override
    public List<Perfil> findAll() {return perfilRepository.findAll();}

    @Override
    public Perfil findById(Long id){
        Perfil perfil = this.perfilRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Perfil no encontrado"));
        return perfil;
    }

}
