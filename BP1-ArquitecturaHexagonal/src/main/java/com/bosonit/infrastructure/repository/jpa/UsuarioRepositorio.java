package com.bosonit.infrastructure.repository.jpa;

import com.bosonit.domain.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntity, Integer> {
    //List<UsuarioEntity> findByUsuario(String nombre);
}
