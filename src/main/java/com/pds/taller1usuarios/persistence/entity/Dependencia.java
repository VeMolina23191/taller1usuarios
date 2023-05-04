package com.pds.taller1usuarios.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="dependencias")
public class Dependencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dependencia")
    private Long id_dependencia;

    @NotNull
    private String nombre_dependencia;

    @OneToMany(mappedBy = "dependencia", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;


    @ManyToOne(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_usuario") //Columna con la cláve foránea
    private Usuario usuario;

}