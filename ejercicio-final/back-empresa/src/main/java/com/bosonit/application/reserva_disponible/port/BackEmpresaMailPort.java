package com.bosonit.application.reserva_disponible.port;

public interface BackEmpresaMailPort {
    void sendEmail(String destinatario, String asunto, String contenido);
}
