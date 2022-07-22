package com.bosonit.domain;

import com.bosonit.infrastructure.controller.dto.input.UsuarioInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Persona")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Persona")
    private Integer id_persona;

    @Size(min = 6, max = 10)
    @Column(name = "Usuario", nullable = false)
    private String usuario;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Surname", nullable = false)
    private String surname;
    @Column(name = "Company_email", nullable = false)
    private String company_email;

    @Column(name = "Personal_email", nullable = false)
    private String personal_email;

    @Column(name = "Ciudad", nullable = false)
    private String city;

    @Column(name = "Activo", nullable = false)
    private Boolean active;

    @Column(name = "Created_Date", nullable = false)
    private Date created_date;

    @Column(name = "Imagen_URL")
    private String imagen_url;

    @Column(name = "Date")
    private Date termination_date;


    public UsuarioEntity(UsuarioInputDTO usuarioInputDTO) {
        if (usuarioInputDTO == null) return;
        id_persona = usuarioInputDTO.getId_persona();
        usuario = usuarioInputDTO.getUsuario();
        password = usuarioInputDTO.getPassword();
        name = usuarioInputDTO.getName();
        surname = usuarioInputDTO.getSurname();
        company_email = usuarioInputDTO.getCompany_email();
        personal_email = usuarioInputDTO.getPersonal_email();
        city = usuarioInputDTO.getCity();
        active = usuarioInputDTO.getActive();
        created_date = usuarioInputDTO.getCreated_date();
        imagen_url = usuarioInputDTO.getImagen_url();
        termination_date = usuarioInputDTO.getTermination_date();
    }

    public void update(UsuarioInputDTO usuarioInputDTO) {
        if (usuarioInputDTO == null) return;
        id_persona = usuarioInputDTO.getId_persona();
        usuario = usuarioInputDTO.getUsuario();
        password = usuarioInputDTO.getPassword();
        name = usuarioInputDTO.getName();
        surname = usuarioInputDTO.getSurname();
        company_email = usuarioInputDTO.getCompany_email();
        personal_email = usuarioInputDTO.getPersonal_email();
        city = usuarioInputDTO.getCity();
        active = usuarioInputDTO.getActive();
        created_date = usuarioInputDTO.getCreated_date();
        imagen_url = usuarioInputDTO.getImagen_url();
        termination_date = usuarioInputDTO.getTermination_date();
    }
}
