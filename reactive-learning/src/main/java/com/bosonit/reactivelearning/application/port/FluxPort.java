package com.bosonit.reactivelearning.application.port;

import reactor.core.publisher.Flux;

public interface FluxPort {
    Flux<Integer> integerFlux();

    Flux<Integer> integerStreamFlux();
}
