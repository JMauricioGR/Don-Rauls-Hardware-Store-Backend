package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import com.donrauls.hadwarestore.dtos.ReceiptDTO;
import com.donrauls.hadwarestore.usecases.CreateReceiptUseCase;
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
public class CreateReceiptRoute {
    @Bean
    @RouterOperation(operation = @Operation(description = "Create receipt ", operationId = "createReceipt", tags = "Receipt",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ReceiptDTO.class)))))
    public RouterFunction<ServerResponse> createReceipt(CreateReceiptUseCase createReceiptUseCase){
        Function<ReceiptDTO, Mono<ServerResponse>> executeCreate = receiptDTO -> createReceiptUseCase.applyReceipt(receiptDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
        return route(POST("receipt/create").and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(ReceiptDTO.class).flatMap(executeCreate));
    }
}
