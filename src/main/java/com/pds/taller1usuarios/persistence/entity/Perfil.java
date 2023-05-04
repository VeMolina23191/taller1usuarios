package com.pds.taller1usuarios.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="perfiles")
@Getter
@Setter
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_perfil")
    private long id_perfil;

    private String nombre_perfil;


    @OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;


    @ManyToOne(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_usuario") //Columna con la cláve foránea
    private Usuario usuario;
}