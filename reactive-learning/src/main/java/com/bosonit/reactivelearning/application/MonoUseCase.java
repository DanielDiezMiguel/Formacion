package com.bosonit.reactivelearning.application;

import com.bosonit.reactivelearning.application.port.MonoPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MonoUseCase implements MonoPort {

    @Override
    public Mono<Integer> integerMono() {
        return Mono.just(1).log();
    }

}
