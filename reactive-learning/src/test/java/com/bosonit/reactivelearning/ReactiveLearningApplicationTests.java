package com.bosonit.reactivelearning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class ReactiveLearningApplicationTests {

    @Test
    void fluxTextOnError() {
        Flux<String> stringFlux = Flux
                .just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Ocurred")))
                .concatWith(Flux.just("After Error"))
                .log();

        stringFlux.subscribe(System.out::println, Throwable::getMessage);
    }

    @Test
    void fluxTextOnComplete() {
        Flux<String> stringFlux = Flux
                .just("Spring", "Spring Boot", "Reactive Spring")
                .log();

        stringFlux.subscribe(
                System.out::println,
                Throwable::getMessage,
                () -> System.out.println("Completed"));
    }

    @Test
    void fluxTextNoError() {
        Flux<String> stringFlux = Flux
                .just("Spring", "Spring Boot", "Reactive Spring")
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("Spring", "Spring Boot", "Reactive Spring")
                .verifyComplete();
    }

}