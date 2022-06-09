package com.donrauls.hadwarestore.repositories;

import com.donrauls.hadwarestore.collections.Providers;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProvidersInterface extends ReactiveMongoRepository<Providers, String> {
}
