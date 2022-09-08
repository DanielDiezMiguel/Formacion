package com.bosonit.application.mail.port;

import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailInputDTO;
import org.springframework.http.ResponseEntity;

public interface BackEmpresaMailCreatePort {
    ResponseEntity sendEmail(String destinatario, String asunto, String contenido);

}
