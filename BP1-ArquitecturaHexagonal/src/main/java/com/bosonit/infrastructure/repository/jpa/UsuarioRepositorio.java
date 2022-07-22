package com.bosonit.infrastructure.repository.jpa;

import com.bosonit.domain.UsuarioEntity;
import com.bosonit.infrastructure.controller.dto.output.UsuarioOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntity, Integer> {
    List<UsuarioOutputDTO> findByName(String name);
}
