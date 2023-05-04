package com.pds.taller1usuarios.mapper;

import com.pds.taller1usuarios.persistence.entity.Usuario;
import com.pds.taller1usuarios.services.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDTOtoUsuario implements IMapper<UsuarioDTO, Usuario>{

    @Override
    public Usuario mapper(UsuarioDTO in) {
        Usuario usuario= new Usuario();
        usuario.setFecha_nacimiento(in.getFecha_nacimiento());
        usuario.setActivo(in.isActivo());
        return usuario;
    }
}
