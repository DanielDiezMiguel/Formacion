package com.bosonit.reactivelearning.application;

import com.bosonit.reactivelearning.application.port.FluxPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class FluxUseCase implements FluxPort {

    @Override
    public Flux<Integer> integerFlux() {
        return Flux.just(1, 2, 3, 4, 5).log();
    }

    @Override
    public Flux<Integer> integerStreamFlux() {
        return Flux.just(1, 2, 3, 4, 5)
                .delayElements(Duration.ofSeconds(1))
                .log();
    }
}
