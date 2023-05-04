package com.pds.taller1usuarios.repository;

import com.pds.taller1usuarios.persistence.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
