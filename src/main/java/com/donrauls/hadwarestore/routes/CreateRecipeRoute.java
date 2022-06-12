package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.collections.Recipes;
import com.donrauls.hadwarestore.dtos.RecipesDTO;
import com.donrauls.hadwarestore.usecases.CreateRecipeUseCase;
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
public class CreateRecipeRoute {
    @Bean
    @RouterOperation(operation = @Operation(description = "Create recipe ", operationId = "createRecipe", tags = "Recipe",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = RecipesDTO.class)))))
    public RouterFunction<ServerResponse> createRecipe(CreateRecipeUseCase createRecipeUseCase){
        Function<RecipesDTO, Mono<ServerResponse>> executeCreate = recipesDTO -> createRecipeUseCase.applyRecipe(recipesDTO).flatMap(result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(result));
        return route(POST("recipe/create").and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(RecipesDTO.class).flatMap(executeCreate));
    }
}
