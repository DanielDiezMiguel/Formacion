package com.bosonit.infrastructure.mail.controller.dto;

import com.bosonit.domain.mail.BackEmpresaMailCollection;
import lombok.Data;

@Data
public class BackEmpresaMailOutputDTO {
    String id_mail;
    String destinatario;
    String asunto;
    String contenido;

    public BackEmpresaMailOutputDTO(BackEmpresaMailCollection backEmpresaMailCollection) {
        if (backEmpresaMailCollection == null) return;
        destinatario = backEmpresaMailCollection.getDestinatario();
        asunto = backEmpresaMailCollection.getAsunto();
        contenido = backEmpresaMailCollection.getContenido();
    }
}
