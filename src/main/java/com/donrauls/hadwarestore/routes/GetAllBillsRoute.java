package com.donrauls.hadwarestore.routes;


import com.donrauls.hadwarestore.dtos.BillsDTO;
import com.donrauls.hadwarestore.usecases.GetAllBillsUseCase;
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
public class GetAllBillsRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Get all bills created", operationId = "bills", tags = "Bills",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = BillsDTO.class)))))
    public RouterFunction<ServerResponse> allBills(GetAllBillsUseCase getAllBillsUseCase){
        return route(GET("bills/all"), request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromPublisher(getAllBillsUseCase.getAllBills(), BillsDTO.class)));
    }
}
