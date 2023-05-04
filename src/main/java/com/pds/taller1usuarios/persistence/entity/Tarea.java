package com.pds.taller1usuarios.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table (name="tareas")
public class Tarea {

    @Id
    @Column(name="id_tarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarea;

    private String nombre_tarea;


    //Relación con Fila
    /*
    @OneToOne(fetch = FetchType.EAGER, optional = true)
    //@JoinColumn(name = "id_fila", nullable = true)
    private Fila fila;*/

}
