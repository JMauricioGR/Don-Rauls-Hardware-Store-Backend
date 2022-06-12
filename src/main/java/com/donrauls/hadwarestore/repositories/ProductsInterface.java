package com.donrauls.hadwarestore.repositories;

import com.donrauls.hadwarestore.collections.Products;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsInterface extends ReactiveMongoRepository<Products, String> {
}
