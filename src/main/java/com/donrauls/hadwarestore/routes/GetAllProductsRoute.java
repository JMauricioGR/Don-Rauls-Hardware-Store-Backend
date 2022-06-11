package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.dtos.ProductsDTO;
import com.donrauls.hadwarestore.usecases.GetAllProductsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProductsRoute {

    @Bean
    public RouterFunction<ServerResponse> allProducts(GetAllProductsUseCase getAllProductsUseCase){
        return route(GET("products/all"), request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromPublisher(getAllProductsUseCase.getAllProducts(), ProductsDTO.class)));
    }

}
