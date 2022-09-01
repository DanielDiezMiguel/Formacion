package com.bosonit.application.reserva_disponible.port;

import com.bosonit.domain.no_collection.KafkaItemReservas;
import com.bosonit.domain.no_collection.KafkaItemReservasDisponibles;

public interface KafkaBackEmpresaProducerPort {

    void sendMessage(KafkaItemReservasDisponibles kafkaItemReservasDisponibles);
}
