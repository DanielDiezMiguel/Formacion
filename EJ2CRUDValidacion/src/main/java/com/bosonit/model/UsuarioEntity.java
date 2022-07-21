package com.bosonit.model;

import com.bosonit.dto.UsuarioInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
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

    @NonNull
    @Column(name = "Usuario")
    private String usuario;

    @NonNull
    @Column(name = "Password")
    private String password;

    @NonNull
    @Column(name = "Nombre")
    private String name;

    @NonNull
    @Column(name = "Surname")
    private String surname;

    @NonNull
    @Column(name = "Company_email")
    private String company_email;

    @NonNull
    @Column(name = "Personal_email")
    private String personal_email;

    @NonNull
    @Column(name = "Ciudad")
    private String city;

    @NonNull
    @Column(name = "Activo")
    private Boolean active;

    @NonNull
    @Column(name = "Created_Date")
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
}
