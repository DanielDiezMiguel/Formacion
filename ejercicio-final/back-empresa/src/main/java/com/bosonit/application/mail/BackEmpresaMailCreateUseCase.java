package com.bosonit.application.mail;

import com.bosonit.application.mail.port.BackEmpresaMailCreatePort;
import com.bosonit.domain.mail.BackEmpresaMailCollection;
import com.bosonit.infrastructure.mail.repository.mongodb.MongoDBRespositoryMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BackEmpresaMailCreateUseCase implements BackEmpresaMailCreatePort {

    @Autowired
    MongoDBRespositoryMail mongoDBRespositoryMail;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public ResponseEntity sendEmail(String destinatario, String asunto, String contenido) {
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

        return ResponseEntity.ok("Correo enviado");
    }

}
