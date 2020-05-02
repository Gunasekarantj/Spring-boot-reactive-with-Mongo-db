package com.learnreactivespring.fluxandmonoplayground;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxandMonoFactoryTest {
	 List<String> names = Arrays.asList("Adam","Anna","Jack","Jenny");
		/*
		 * @Test public void fluxUsingIterable() { Flux<String> namesFlux =
		 * Flux.fromIterable(names).log();
		 * StepVerifier.create(namesFlux).expectNext("Adam","Anna","Jack","Jenny")
		 * .verifyComplete();
		 * 
		 * }
		 */
 /*  
   @Test
   public void fluxUsingArray() {
	  String [] names= new String[] {"Adam","Anna","Jack","Jenny"};
	  Flux<String> namesFlux = Flux.fromArray(names).log();
	  StepVerifier.create(namesFlux).expectNext("Adam","Anna","Jack","Jenny")
	  .verifyComplete();
   }
   
   @Test
   public void fluxUsingStream() {
	   Flux<String> namesFlux = Flux.fromStream(names.stream()).log();
	  StepVerifier.create(namesFlux).expectNext("Adam","Anna","Jack","Jenny")
	  .verifyComplete();
   }*/
		/*
		 * @Test public void monoUsingJustorEmpty() { Mono<String> mono
		 * =Mono.justOrEmpty(null); StepVerifier.create(mono.log()).verifyComplete(); }
		 */
		/*
		 * @Test public void monoUsingSupplier() { Supplier<String> stringSupplier=
		 * ()->"adam"; Mono<String> stringMono=Mono.fromSupplier(stringSupplier);
		 * System.out.println(stringSupplier.get());
		 * StepVerifier.create(stringMono.log()).expectNext("adam") .verifyComplete(); }
		 * 
		 * @Test public void fluxUsingRange() { Flux<Integer>
		 * integerFlux=Flux.range(start:1,count:5).log();
		 * StepVerifier.create(integerFlux).expectNext(1,2,3,4,5).verifyComplete(); }
		 */
}
