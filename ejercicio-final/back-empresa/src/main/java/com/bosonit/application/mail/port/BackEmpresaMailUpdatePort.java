package com.bosonit.application.mail.port;

import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailInputDTO;
import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BackEmpresaMailUpdatePort {
    ResponseEntity sendEmail(BackEmpresaMailInputDTO backEmpresaMailInputDTO, String destinatario, String asunto, String contenido);
}
