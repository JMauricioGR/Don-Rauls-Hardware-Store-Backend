package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import com.donrauls.hadwarestore.usecases.GetAllProvidersUseCase;
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
public class GetAllProvidersRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Get all providers from the database", operationId = "GetProviders", tags = "Provider",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProvidersDTO.class)))))
    public RouterFunction<ServerResponse> allProviders(GetAllProvidersUseCase getAllProvidersUseCase){
        return route(GET("providers/all"), request-> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromPublisher(getAllProvidersUseCase.getAllProviders(), ProvidersDTO.class)));
    }
}
