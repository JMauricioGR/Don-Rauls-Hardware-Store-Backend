package com.donrauls.hadwarestore.routes;


import com.donrauls.hadwarestore.usecases.DeleteProductUseCase;
import com.mongodb.internal.connection.Server;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProductRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Delete product by product id", operationId = "deleteProduct", tags = "Product", parameters = { @Parameter(in = ParameterIn.PATH, name = "id", description = "Product Id") },
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Void.class)))))
    RouterFunction<ServerResponse> deleteProduct(DeleteProductUseCase deleteProductUseCase){
        return route(DELETE("product/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.OK)
                        .body(BodyInserters.fromPublisher(deleteProductUseCase.applyProduct(request.pathVariable("id")),Void.class)));
    }
}
