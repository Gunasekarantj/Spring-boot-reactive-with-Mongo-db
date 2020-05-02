package com.learnreactivespring.fluxandmonoplayground;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxandMonoTest {
	/*
	 * @Test public void fluxTest() { Flux<String> stringFlux=
	 * Flux.just("Spring","Spring Boot","Reactive Spring")
	 * .concatWith(Flux.error(new RuntimeException("Exception occured")))
	 * .concatWith(Flux.just("After error")) .log();
	 * stringFlux.subscribe(System.out::println,(e)->System.err.
	 * println("Exception is"+e),()->System.out.println("Completed")); }
	 */

	/*
	 * @Test public void fluxTestElements_WithoutError() { Flux<String>
	 * stringFlux=Flux.just("Spring","Spring Boot","Reactive Spring")
	 * //.concatWith(Flux.error(new RuntimeException("Exception occured"))) .log();
	 * StepVerifier.create(stringFlux)
	 * .expectNext("Spring","Spring Boot","Reactive Spring") //.expectNext("Spring"
	 * //.expectNext("Spring Boot") // .expectNext("Reactive Spring") //
	 * .expectError(RuntimeException.class) .expectErrorMessage("Exception Occured")
	 * .verify(); }
	 */
	/*
	 * @Test public void monoTest() { Mono<String> stringMono=Mono.just("Spring");
	 * StepVerifier.create(stringMono.log()) .expectNext("Spring")
	 * .verifyComplete(); }
	 */
	
	/*
	 * @Test public void monoTest_Error() { Mono<String>
	 * stringMono=Mono.just("Spring"); StepVerifier.create(Mono.error(new
	 * RuntimeException("Exception Occured")).log())
	 * .expectError(RuntimeException.class) .verify(); }
	 */
}
