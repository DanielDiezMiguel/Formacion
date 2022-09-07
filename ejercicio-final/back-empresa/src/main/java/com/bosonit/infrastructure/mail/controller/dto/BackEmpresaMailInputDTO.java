package com.bosonit.infrastructure.mail.controller.dto;

import lombok.Data;

@Data
public class BackEmpresaMailInputDTO {
    String id_mail;
    String destinatario;
    String asunto;
    String contenido;
}
