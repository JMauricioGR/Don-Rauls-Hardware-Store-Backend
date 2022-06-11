package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.dtos.ProductsDTO;
import com.donrauls.hadwarestore.usecases.CreateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import java.util.function.Function;

@Configuration
public class CreateProductRoute {
    @Bean
    public RouterFunction<ServerResponse> createProduct(CreateProductUseCase createProductUseCase){
        Function<ProductsDTO, Mono<ServerResponse>> executeCreate = productsDTO -> createProductUseCase.applyProduct(productsDTO).flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(result));
        return route(POST("product/create").and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(ProductsDTO.class).flatMap(executeCreate));
    }
}
