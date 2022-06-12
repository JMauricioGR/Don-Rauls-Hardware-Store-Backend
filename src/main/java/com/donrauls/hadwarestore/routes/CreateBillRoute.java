package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.dtos.BillsDTO;
import com.donrauls.hadwarestore.usecases.CreateBillUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CreateBillRoute {
    @Bean
    @RouterOperation(operation = @Operation(description = "Create bill ", operationId = "createBill", tags = "Bills",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = BillsDTO.class)))))
    public RouterFunction<ServerResponse> createBill(CreateBillUseCase createBillUseCase){
        Function<BillsDTO, Mono<ServerResponse>> executeCreate = billsDTO -> createBillUseCase.applyBill(billsDTO).flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(result));
        return route(POST("bill/create").and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(BillsDTO.class).flatMap(executeCreate));
    }
}
