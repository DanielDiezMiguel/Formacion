package com.bosonit.application.mail;

import com.bosonit.application.mail.port.BackEmpresaMailReadPort;
import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailOutputDTO;
import com.bosonit.infrastructure.mail.repository.mongodb.MongoDBRespositoryMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackEmpresaMailReadUseCase implements BackEmpresaMailReadPort {

    @Autowired
    MongoDBRespositoryMail mongoDBRespositoryMail;

    @Override
    public ResponseEntity getEmails() {
        List<BackEmpresaMailOutputDTO> backEmpresaMailOutputDTOList = new ArrayList<>();

        mongoDBRespositoryMail.findAll()
                .forEach(backEmpresaMailCollection -> backEmpresaMailOutputDTOList
                        .add(new BackEmpresaMailOutputDTO(backEmpresaMailCollection)));

        return ResponseEntity.ok(backEmpresaMailOutputDTOList);
    }

}
