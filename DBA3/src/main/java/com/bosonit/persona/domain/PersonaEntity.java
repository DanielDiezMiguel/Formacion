package com.bosonit.persona.domain;

import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;


    public PersonaEntity(PersonaInputDTO usuarioInputDTO) {
        if (usuarioInputDTO == null) return;
        id_persona = usuarioInputDTO.getId_persona();
        usuario = usuarioInputDTO.getUsuario();
        password = usuarioInputDTO.getPassword();
        name = usuarioInputDTO.getName();
        surname = usuarioInputDTO.getSurname();
    }

    public void update(PersonaInputDTO usuarioInputDTO) {
        if (usuarioInputDTO == null) return;
        id_persona = usuarioInputDTO.getId_persona();
        usuario = usuarioInputDTO.getUsuario();
        password = usuarioInputDTO.getPassword();
        name = usuarioInputDTO.getName();
        surname = usuarioInputDTO.getSurname();
    }
}
