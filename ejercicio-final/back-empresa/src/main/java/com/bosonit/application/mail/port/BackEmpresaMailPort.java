package com.bosonit.application.mail.port;

public interface BackEmpresaMailPort {
    void sendEmail(String destinatario, String asunto, String contenido);
}
