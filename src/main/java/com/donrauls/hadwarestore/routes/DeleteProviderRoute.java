package com.donrauls.hadwarestore.routes;


import com.donrauls.hadwarestore.usecases.DeleteProviderUseCase;
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
public class DeleteProviderRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Delete provider by id", operationId = "deleteProvider", tags = "Provider", parameters = { @Parameter(in = ParameterIn.PATH, name = "id", description = "Provider Id") },
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Void.class)))))
    RouterFunction<ServerResponse> deleteProvider(DeleteProviderUseCase deleteProviderUseCase){
        return route(DELETE("provider/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.OK)
                        .body(BodyInserters.fromPublisher(deleteProviderUseCase.apply(request.pathVariable("id")), Void.class)));
    }
}
