package com.pds.taller1usuarios.controller;

import com.pds.taller1usuarios.persistence.entity.Perfil;
import com.pds.taller1usuarios.services.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perfil")
@RequiredArgsConstructor
public class PerfilController {
    private final PerfilService perfilService;

    @GetMapping
    public List<Perfil> findAll() { return perfilService.findAll();}

}
