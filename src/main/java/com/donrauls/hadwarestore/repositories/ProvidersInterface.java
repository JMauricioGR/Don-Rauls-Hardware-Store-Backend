package com.donrauls.hadwarestore.repositories;

import com.donrauls.hadwarestore.collections.Providers;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersInterface extends ReactiveMongoRepository<Providers, String> {
}
