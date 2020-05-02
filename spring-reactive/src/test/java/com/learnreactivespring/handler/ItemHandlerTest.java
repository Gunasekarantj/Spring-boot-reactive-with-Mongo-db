package com.learnreactivespring.handler;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.learnreactivespring.constansts.ItemConstants;
import com.learnreactivespring.document.Item;
import com.learnreactivespring.repository.ItemReactiveRepository;

import reactor.core.publisher.Flux;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
public class ItemHandlerTest {
	@Autowired
	WebTestClient webTestClient;
    
	@Autowired
	@Qualifier("ItemReactiveRepository")
	ItemReactiveRepository itemReactiveRepository;
	public List<Item> data() {
		return Arrays.asList(new Item(null, "Samsung TV", 399.99), new Item(null, "LG TV", 329.99),
				new Item(null, "AppleWatch", 349.99), new Item("ABC", "Beats Headphones", 399.99));

	}

	@Before
	public void setUp() {
    itemReactiveRepository.deleteAll()
    .thenMany(Flux.fromIterable(data()))
    .flatMap(itemReactiveRepository::save)
    .doOnNext((item->{
    	System.out.println("Inserted item is :"+item);
    }))
    .blockLast();
	}
    @Test
	public void getAllItems() {
		webTestClient.get().uri(ItemConstants.ITEM_FUNCTIONAL_END_POINT_V1)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBodyList(Item.class)
		.hasSize(4);
	}
    @Test
    public void getOneItem() {
    	webTestClient.get().uri(ItemConstants.ITEM_FUNCTIONAL_END_POINT_V1.concat("/{id"),"ABC")
    	.exchange()
    	.expectStatus().isOk()
        .expectBody()
        .jsonPath("$.price",149.99);
    }
    @Test
    public void getOneItem_notFound() {
    	webTestClient.get().uri(ItemConstants.ITEM_FUNCTIONAL_END_POINT_V1.concat("/{id"),"ABC")
    	.exchange()
    	.expectStatus().isNotFound();
    }
    @Test
    public void runTimeException() {
    	webTestClient.get().uri("/fun/runtimeexception")
    	.exchange()
    	.expectStatus().is5xxServerError()
    	.expectBody()
    	.jsonPath("$.message","RuntimeException Occured");
    }
}
