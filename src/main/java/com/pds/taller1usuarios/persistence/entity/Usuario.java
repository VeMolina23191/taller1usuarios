package com.pds.taller1usuarios.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long id_usuario;

    private LocalDate fecha_nacimiento;
    private boolean activo;

    //Relaciones

    //Relacion con Fila
    @OneToMany(mappedBy = "usuario", fetch =FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Fila> filas;

    //Relacion con Dependencia
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_dependencia")
    private Dependencia dependencia;

    //Relacion con perfil
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

}
