package com.donrauls.hadwarestore.routes;


import com.donrauls.hadwarestore.dtos.RecipesDTO;
import com.donrauls.hadwarestore.usecases.GetAllRecipesUseCase;
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
public class GetAllRecipesRoute {

    @Bean
    @RouterOperation(operation = @Operation(description = "Get all recipes from the database", operationId = "getRecipes", tags = "Recipe",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = RecipesDTO.class)))))
    public RouterFunction<ServerResponse> allRecipes(GetAllRecipesUseCase getAllRecipesUseCase){
        return route(GET("recipes/all"), request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromPublisher(getAllRecipesUseCase.getAllRecipes(), RecipesDTO.class)));
    }
}
