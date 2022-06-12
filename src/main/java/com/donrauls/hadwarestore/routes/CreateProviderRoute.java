package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import com.donrauls.hadwarestore.usecases.CreateProviderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
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
public class CreateProviderRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Create provider ", operationId = "createProvider", tags = "Provider",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ProvidersDTO.class)))))
    public RouterFunction<ServerResponse> createProvider(CreateProviderUseCase createProviderUseCase){
        Function<ProvidersDTO, Mono<ServerResponse>> executeCreate = providerDTO
-> createProviderUseCase.apply(providerDTO)
                .flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(result));
        return route(POST("provider/create").and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(ProvidersDTO.class).flatMap(executeCreate));
    }
}
