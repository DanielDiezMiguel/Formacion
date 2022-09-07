package com.bosonit.application.mail;

import com.bosonit.application.mail.port.BackEmpresaMailPort;
import com.bosonit.domain.mail.BackEmpresaMailCollection;
import com.bosonit.infrastructure.mail.controller.dto.BackEmpresaMailOutputDTO;
import com.bosonit.infrastructure.mail.repository.mongodb.MongoDBRespositoryMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackEmpresaMailUseCase implements BackEmpresaMailPort {

    @Autowired
    MongoDBRespositoryMail mongoDBRespositoryMail;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String destinatario, String asunto, String contenido) {
        BackEmpresaMailCollection backEmpresaMailCollection = new BackEmpresaMailCollection();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(contenido);

        backEmpresaMailCollection.setDestinatario(destinatario);
        backEmpresaMailCollection.setAsunto(asunto);
        backEmpresaMailCollection.setContenido(contenido);

        mongoDBRespositoryMail.save(backEmpresaMailCollection);
        javaMailSender.send(simpleMailMessage);
    }

}
