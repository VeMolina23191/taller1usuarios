package com.pds.taller1usuarios.services.dto;
import com.pds.taller1usuarios.persistence.entity.Dependencia;
import com.pds.taller1usuarios.persistence.entity.Fila;
import com.pds.taller1usuarios.persistence.entity.Perfil;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class UsuarioDTO {

    //private Long id_usuario;
    private LocalDate fecha_nacimiento;
    private boolean activo;

    private List<Fila> filas;

    private Dependencia dependencia;

    private Perfil[] perfiles;

}
