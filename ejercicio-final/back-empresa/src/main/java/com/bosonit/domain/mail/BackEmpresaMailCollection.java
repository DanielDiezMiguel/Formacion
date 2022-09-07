package com.bosonit.domain.mail;

import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "mail")
public class BackEmpresaMailCollection {
    @Id
    String id_mail;
    String destinatario;
    String asunto;
    String contenido;

    public BackEmpresaMailCollection(BackEmpresaMailInputDTO backEmpresaMailInputDTO) {
        if (backEmpresaMailInputDTO == null) return;
        destinatario = backEmpresaMailInputDTO.getDestinatario();
        asunto = backEmpresaMailInputDTO.getAsunto();
        contenido = backEmpresaMailInputDTO.getContenido();
    }

}
