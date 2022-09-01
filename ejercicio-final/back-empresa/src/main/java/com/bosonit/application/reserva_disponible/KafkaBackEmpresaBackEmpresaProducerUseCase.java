package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.KafkaBackEmpresaProducerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaBackEmpresaBackEmpresaProducerUseCase implements KafkaBackEmpresaProducerPort {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send("reservas-disponibles", message);
    }
}
