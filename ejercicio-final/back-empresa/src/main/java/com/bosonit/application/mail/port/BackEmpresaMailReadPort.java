package com.bosonit.application.mail.port;

import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BackEmpresaMailReadPort {
    ResponseEntity<List<BackEmpresaMailOutputDTO>> getEmails();
}
