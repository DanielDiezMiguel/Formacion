package com.bosonit.application.mail;

import com.bosonit.application.mail.port.BackEmpresaMailUpdatePort;
import com.bosonit.domain.mail.BackEmpresaMailCollection;
import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailInputDTO;
import com.bosonit.infrastructure.mail.repository.mongodb.MongoDBRespositoryMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BackEmpresaMailUpdateUseCase implements BackEmpresaMailUpdatePort {

    @Autowired
    MongoDBRespositoryMail mongoDBRespositoryMail;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public ResponseEntity sendEmail(BackEmpresaMailInputDTO backEmpresaMailInputDTO, String destinatario, String asunto, String contenido) {
        BackEmpresaMailCollection backEmpresaMailCollection = new BackEmpresaMailCollection();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(backEmpresaMailInputDTO.getDestinatario());
        simpleMailMessage.setSubject(backEmpresaMailInputDTO.getAsunto());
        simpleMailMessage.setText(backEmpresaMailInputDTO.getContenido());

        backEmpresaMailCollection.update(backEmpresaMailInputDTO);
        mongoDBRespositoryMail.save(backEmpresaMailCollection);

        javaMailSender.send(simpleMailMessage);
        return ResponseEntity.ok("Correo enviado");
    }

}
