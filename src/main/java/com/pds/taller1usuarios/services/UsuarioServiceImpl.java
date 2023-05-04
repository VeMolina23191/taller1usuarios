package com.pds.taller1usuarios.services;

import com.pds.taller1usuarios.exceptions.UsuarioException;
import com.pds.taller1usuarios.mapper.UsuarioDTOtoUsuario;
import com.pds.taller1usuarios.persistence.entity.Usuario;
import com.pds.taller1usuarios.repository.UsuarioRepository;
import com.pds.taller1usuarios.services.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioDTOtoUsuario usuarioDTOtoUsuario;

    //Crear usuario
    @Override
    public Usuario createUsuario(Usuario usuario){
        System.out.println("CreateUsuarioDTO" + usuario.getFilas());
        return usuarioRepository.save(usuario);
    }

    //Listar usuarios
    @Override
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    //Listar usuario por id
    public Usuario findById(Long id_usuario){
        Optional<Usuario> usuario = usuarioRepository.findById(id_usuario);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            throw new UsuarioException("No se encontro el usuario " + id_usuario);
        }
    }

    //Actualizar usuario
    public Usuario updateUsuario(Usuario usuario){
        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return updatedUsuario;
    }

    //Eliminar usuario
    public void deleteUsuario(Long id_usuario){
        usuarioRepository.deleteById(id_usuario);
    }

}
