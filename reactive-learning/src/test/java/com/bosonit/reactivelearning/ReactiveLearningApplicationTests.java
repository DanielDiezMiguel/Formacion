package com.bosonit.reactivelearning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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

    @Test
    void fluxTextError() {
        Flux<String> stringFlux = Flux
                .just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("ERROR OCURRED")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("Spring", "Spring Boot", "Reactive Spring")
                .expectErrorMessage("ERROR OCURRED")
                .verify();
    }

    @Test
    void fluxTextCountError() {
        Flux<String> stringFlux = Flux
                .just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException()))
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(3)
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    void monoTest() {
        Mono<String> stringMono = Mono.just("Spring");
        StepVerifier.create(stringMono.log())
                .expectNext("Spring")
                .verifyComplete();
    }

    @Test
    void monoTestError() {
        StepVerifier.create(
                Mono.error(new RuntimeException("ERROR OCURRED"))
                        .log())
                .expectError(RuntimeException.class)
                .verify();
    }
}