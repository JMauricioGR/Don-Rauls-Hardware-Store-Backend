package com.donrauls.hadwarestore.repositories;

import com.donrauls.hadwarestore.collections.Recipes;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecipesInterface extends ReactiveMongoRepository<Recipes, String> {
}
