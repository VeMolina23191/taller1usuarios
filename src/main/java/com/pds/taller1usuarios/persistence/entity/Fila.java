package com.pds.taller1usuarios.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "filas")
public class Fila {

    @Id
    @Column(name = "id_fila")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fila;

    private int duracion;

    //Relaciones
    //Relacion con Tarea
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarea")
    private Tarea tarea;

    //Relacion con Usuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
