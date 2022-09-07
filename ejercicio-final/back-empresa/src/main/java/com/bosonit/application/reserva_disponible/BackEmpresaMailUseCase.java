package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.BackEmpresaMailPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BackEmpresaMailUseCase implements BackEmpresaMailPort {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String destinatario, String asunto, String contenido) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(contenido);
        javaMailSender.send(simpleMailMessage);
    }

}
