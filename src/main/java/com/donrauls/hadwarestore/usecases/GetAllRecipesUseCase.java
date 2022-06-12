package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.RecipesDTO;
import com.donrauls.hadwarestore.mappers.RecipesMapper;
import com.donrauls.hadwarestore.repositories.RecipesInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllRecipesUseCase {

    private RecipesMapper recipesMapper;
    private RecipesInterface recipesInterface;

    public Flux<RecipesDTO> getAllRecipes(){
        return recipesInterface.findAll()
                .map(recipe -> recipesMapper.recipesToDTO().apply(recipe));
    }
}
