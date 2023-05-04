package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.persistence.entity.Usuario;
import com.pds.taller1usuarios.services.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    //Crear usuario
    Usuario createUsuario(Usuario usuario);

    //Listar usuarios
    List<Usuario> findAll();

    //Listar usuario por id
    Usuario findById(Long id_usuario);

    //Actualizar usuario
    Usuario updateUsuario(Usuario usuario);

    //Eliminar usuario
    void deleteUsuario(Long id_usuario);
}
