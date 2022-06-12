package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.dtos.ProductsDTO;
import com.donrauls.hadwarestore.usecases.UpdateProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateProductRoute {
    @Bean
    @RouterOperation(operation = @Operation(description = "Update product by id", operationId = "updateProduct", tags = "Product",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProductsDTO.class)))))
    RouterFunction<ServerResponse> updateProduct(UpdateProductUseCase updateProductUseCase){
        return route(PUT("update/product/{id}").and(accept(MediaType.APPLICATION_JSON)),request -> request.bodyToMono(ProductsDTO.class)
                .flatMap(productsDTO -> updateProductUseCase.applyProduct(request.pathVariable("id"), productsDTO))
                .flatMap(result -> result.getProductName()!= null? ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result)
                        : ServerResponse.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).bodyValue(result)));
    }
}
