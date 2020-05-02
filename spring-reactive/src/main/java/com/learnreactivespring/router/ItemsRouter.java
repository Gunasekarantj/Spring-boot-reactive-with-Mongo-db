package com.learnreactivespring.router;

import static com.learnreactivespring.constansts.ItemConstants.ITEM_FUNCTIONAL_END_POINT_V1;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.learnreactivespring.handler.ItemsHandler;

@Configuration
public class ItemsRouter {
    @Bean
    public 	RouterFunction<ServerResponse> itemsRoute(ItemsHandler itemsHandler){
    	return RouterFunctions
    			.route(GET(ITEM_FUNCTIONAL_END_POINT_V1).and(accept(MediaType.APPLICATION_JSON)),
    					itemsHandler::getAllItems)
    			.andRoute(GET(ITEM_FUNCTIONAL_END_POINT_V1+"/{id}").and(accept(MediaType.APPLICATION_JSON))
    			.and(accept(MediaType.APPLICATION_JSON)),itemsHandler::getOneItem)
    			.andRoute(POST(ITEM_FUNCTIONAL_END_POINT_V1).and(accept(MediaType.APPLICATION_JSON)),
    					itemsHandler::createItem)
    			.andRoute(DELETE(ITEM_FUNCTIONAL_END_POINT_V1+"/{id}").and(accept(MediaType.APPLICATION_JSON)),
    					itemsHandler::deleteItem)
    			.andRoute(DELETE(ITEM_FUNCTIONAL_END_POINT_V1+"/{id}").and(accept(MediaType.APPLICATION_JSON)),
    					itemsHandler::updateItem);
    			
    }
    @Bean
    public 	RouterFunction<ServerResponse> errorRoute(ItemsHandler itemsHandler){
    	return RouterFunctions
    			.route(GET("/fun/runtimeexception").and(accept(MediaType.APPLICATION_JSON)),itemsHandler::itemsEx);
    			
    			
    }
}
