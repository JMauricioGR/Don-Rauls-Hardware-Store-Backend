package com.donrauls.hadwarestore.usecases.interfaces;

import com.donrauls.hadwarestore.dtos.RecipesDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateRecipe {
    Mono<RecipesDTO> applyRecipe(RecipesDTO recipesDTO);
}
