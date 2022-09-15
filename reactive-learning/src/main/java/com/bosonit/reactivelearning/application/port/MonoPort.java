package com.bosonit.reactivelearning.application.port;

import reactor.core.publisher.Mono;

public interface MonoPort {
    Mono<Integer> integerMono();
}
