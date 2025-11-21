package org.example.granafacil.infraestructure.gateways.persistence.repositories;

import org.example.granafacil.core.entities.Usuario;
import org.example.granafacil.infraestructure.gateways.persistence.entites.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmail(String email);
}
