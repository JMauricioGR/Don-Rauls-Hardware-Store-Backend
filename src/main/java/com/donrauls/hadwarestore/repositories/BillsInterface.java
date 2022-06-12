package com.donrauls.hadwarestore.repositories;

import com.donrauls.hadwarestore.collections.Bills;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillsInterface extends ReactiveMongoRepository<Bills, String> {
}
