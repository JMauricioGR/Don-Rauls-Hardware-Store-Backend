package com.donrauls.hadwarestore.repositories;

import com.donrauls.hadwarestore.collections.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptInterface extends ReactiveMongoRepository<Receipt, String> {
}
