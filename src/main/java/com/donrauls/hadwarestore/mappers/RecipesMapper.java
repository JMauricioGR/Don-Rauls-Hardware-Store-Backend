package com.donrauls.hadwarestore.mappers;

import com.donrauls.hadwarestore.collections.Recipes;
import com.donrauls.hadwarestore.dtos.RecipesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RecipesMapper {

    private ModelMapper modelMapper;

    public RecipesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Function<Recipes, RecipesDTO> recipesToDTO(){
        return recipesDTO -> modelMapper.map(recipesDTO, RecipesDTO.class);
    }

    public Function<RecipesDTO, Recipes> dtoToRecipes(){
        return recipe -> modelMapper.map(recipe, Recipes.class);
    }


}
