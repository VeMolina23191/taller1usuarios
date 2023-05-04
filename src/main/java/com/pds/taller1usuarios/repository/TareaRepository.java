package com.pds.taller1usuarios.repository;

import com.pds.taller1usuarios.persistence.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository <Tarea, Long> {


}
