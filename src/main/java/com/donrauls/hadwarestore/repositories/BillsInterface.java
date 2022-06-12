package com.donrauls.hadwarestore.repositories;

import com.donrauls.hadwarestore.collections.Bills;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BillsInterface extends ReactiveMongoRepository<Bills, String> {
}
