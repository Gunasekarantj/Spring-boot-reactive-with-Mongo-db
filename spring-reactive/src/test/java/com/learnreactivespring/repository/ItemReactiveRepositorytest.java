package com.learnreactivespring.repository;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learnreactivespring.document.Item;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemReactiveRepositorytest {
   @Autowired
   ItemReactiveRepository itemReactiveRepository;
    List<Item>  itemList = Arrays.asList(new Item(null,"Samsung TV",400.0),
            new Item(null,"LG TV",420.0),
            new Item(null,"Apple Watch",299.99),
            new Item(null,"Beats Headphones",149.99),
            new Item("ABC","Bose Headphones",149.99));

    @Before
    public void setUp(){
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(itemList))
                .flatMap(itemReactiveRepository::save)
                .doOnNext((item -> {
                    System.out.println("Inserted Item is :" + item);
                }))
                .blockLast();
    }
    @Test
    public void getAllItems(){
        StepVerifier.create(itemReactiveRepository.findAll()) // 4
                .expectSubscription()
                .expectNextCount(5)
                .verifyComplete();
    }
    @Test
    public void getItemByID(){
        StepVerifier.create(itemReactiveRepository.findById("ABC"))
                .expectSubscription()
                .expectNextMatches((item -> item.getDescription().equals("Bose Headphones")))
                .verifyComplete();
    }
    @Test
    public void findItemByDescription(){
        StepVerifier.create(itemReactiveRepository.findByDescription("Bose Headphones"))
                .expectSubscription()
                .expectNextCount(1)
                .verifyComplete();
    }
    @Test
    public void saveItem() {
    	Item item=new Item(null,"Google Home Mini",30.00);
    	Mono<Item> savedItem = itemReactiveRepository.save(item);
    	StepVerifier.create(savedItem)
    	.expectSubscription()
    	.expectNextMatches(item1->(item1.getId()!=null&&item1.getDescription().equals("Google Home Mini")))
    	.verifyComplete();
    	
    }
    @Test
    public void updateItem() {
    	double newPrice=520.00;
    	Mono<Item> updatedItem=itemReactiveRepository.findByDescription("LG TV")
    	.map(item->{
    		 item.setPrice(newPrice);
    		 return item;
    	})
    	.flatMap(item->{
    		return itemReactiveRepository.save(item);
    		
    	});
    	StepVerifier.create(updatedItem)
    	.expectSubscription()
    	.expectNextMatches(item->item.getPrice()==520.00)
    	.verifyComplete();
    	
    }
    @Test
    public void deleteItemById() {
    	Mono<Void> deletedItems=itemReactiveRepository.findById("LG TV")
    	.flatMap((item)->{
    		return itemReactiveRepository.delete(item);
    	});
    	StepVerifier.create(deletedItems.log())
    	.expectSubscription()
    	.verifyComplete();
    }
    
    
}
