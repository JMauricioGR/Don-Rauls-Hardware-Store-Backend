package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.dtos.ProductsDTO;
import com.donrauls.hadwarestore.usecases.GetAllProductsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
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
    @RouterOperation(operation = @Operation(description = "Get the information about all products saved", operationId = "getProducts", tags = "Product",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProductsDTO.class)))))
    public RouterFunction<ServerResponse> allProducts(GetAllProductsUseCase getAllProductsUseCase){
        return route(GET("products/all"), request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromPublisher(getAllProductsUseCase.getAllProducts(), ProductsDTO.class)));
    }

}
