package com.learnreactivespring.fluxandmonoplayground;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxandMonoWithTimeTest {
	/*
	 * @Test public void infiniteSequence() throws InterruptedException { Flux<Long>
	 * infiniteFlux=Flux.interval(Duration.ofMillis(200)) .log();
	 * infiniteFlux.subscribe((element)->System.out.println("Value is: "+element));
	 * Thread.sleep(3000);
	 * 
	 * 
	 * }
	 */
	/*
	 * @Test public void infiniteSequenceTest() throws InterruptedException {
	 * Flux<Long> finiteFlux=Flux.interval(Duration.ofMillis(100)) .take(3) .log();
	 * StepVerifier.create(finiteFlux) .expectSubscription() .expectNext(0L,1L,2L)
	 * .verifyComplete(); }
	 */
	
	/*
	 * @Test public void infiniteSequenceMap_withDelay() throws InterruptedException
	 * { Flux<Integer> finiteFlux=Flux.interval(Duration.ofMillis(100))
	 * .delayElements(Duration.ofSeconds(1)) .map(l->new Integer(l.intValue()))
	 * .take(3) .log(); StepVerifier.create(finiteFlux) .expectSubscription()
	 * .expectNext(0,1,2) .verifyComplete(); }
	 */
}
