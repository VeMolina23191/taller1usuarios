package com.pds.taller1usuarios.controller;

import com.pds.taller1usuarios.persistence.entity.Dependencia;
import com.pds.taller1usuarios.services.DependenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dependencia")
@RequiredArgsConstructor
public class DependenciaController {

    private final DependenciaService dependenciaService;

    @GetMapping
    public List<Dependencia> findAll(){ return dependenciaService.findAll();}

}
