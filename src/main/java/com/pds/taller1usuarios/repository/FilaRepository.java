package com.pds.taller1usuarios.repository;

import com.pds.taller1usuarios.persistence.entity.Fila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilaRepository extends JpaRepository<Fila, Long> {

}
