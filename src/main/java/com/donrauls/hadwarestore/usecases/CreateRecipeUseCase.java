package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.RecipesDTO;
import com.donrauls.hadwarestore.mappers.RecipesMapper;
import com.donrauls.hadwarestore.repositories.RecipesInterface;
import com.donrauls.hadwarestore.usecases.interfaces.CreateRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateRecipeUseCase implements CreateRecipe {
    @Autowired
    private RecipesInterface recipesInterface;

    @Autowired
    private RecipesMapper recipesMapper;

    @Override
    public Mono<RecipesDTO> applyRecipe(RecipesDTO recipesDTO) {
        return recipesInterface.save(recipesMapper
                .dtoToRecipes()
                .apply(recipesDTO))
                .map(recipe -> recipesMapper
                        .recipesToDTO().apply(recipe));
    }
}
