package com.pds.taller1usuarios.controller;

import com.pds.taller1usuarios.exceptions.UsuarioException;
import com.pds.taller1usuarios.mapper.UsuarioDTOtoUsuario;
import com.pds.taller1usuarios.persistence.entity.Fila;
import com.pds.taller1usuarios.persistence.entity.Perfil;
import com.pds.taller1usuarios.persistence.entity.Usuario;
import com.pds.taller1usuarios.services.FilaService;
import com.pds.taller1usuarios.services.PerfilService;
import com.pds.taller1usuarios.services.UsuarioService;
import com.pds.taller1usuarios.services.dto.FilaDTO;
import com.pds.taller1usuarios.services.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PerfilService perfilService;

    private final FilaService filaService;

    //Crear usuario
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        //Validando que el usuario sea mayor a 18 años
        LocalDate fecha_nacimiento = usuario.getFecha_nacimiento();
        int edad = calcularEdad(fecha_nacimiento);
        System.out.println("Edad" + edad + "años");
        if(edad >= 18){
            usuario.setActivo(false);
            System.out.println("DTO: " + usuario.getFilas() + usuario.getFecha_nacimiento() + usuario.getDependencia());
            return usuarioService.createUsuario(usuario);
        }else{
            throw new UsuarioException("El usuario debe tener 18 años o mas");
        }
    }

    //Metodo para calcular la edad
    public static int calcularEdad(LocalDate fechaNacimiento){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    //Listar usuarios
    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    //Listar usuarios por id
    @GetMapping("/{id_usuario}")
    public Usuario findById(@PathVariable("id_usuario") Long id_usuario){
        return usuarioService.findById(id_usuario);
    }

    //Actualizar usuario
    @PatchMapping("/{id_usuario}")
    public Usuario updateUsuario(@PathVariable("id_usuario") Long id, @RequestBody Usuario newUsuario){
        Usuario oldUsuario = usuarioService.findById(id);
        if (oldUsuario == null){
            throw new UsuarioException("No se encontró el usuario");
        }else{
            if (newUsuario.getFecha_nacimiento() == null){
                newUsuario.setFecha_nacimiento(oldUsuario.getFecha_nacimiento());
            }
            if (newUsuario.getId_usuario() == null){
                newUsuario.setId_usuario(oldUsuario.getId_usuario());
            }
            //Validando que el usuario sea mayor a 18 años
            LocalDate fecha_nacimiento = newUsuario.getFecha_nacimiento();
            int edad = calcularEdad(fecha_nacimiento);
            if (edad >= 18){
                return usuarioService.updateUsuario(newUsuario);
            }else{
                throw new UsuarioException("El usuario debe tener 18 años o mas");
            }
        }
    }

    //Eliminar usuario
    @DeleteMapping("/{id_usuario}")
    public void deleteUsuario(@PathVariable("id_usuario") Long id_usuario){
        usuarioService.deleteUsuario(id_usuario);
    }
}
