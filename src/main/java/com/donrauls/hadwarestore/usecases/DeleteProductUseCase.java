package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.repositories.ProductsInterface;
import com.donrauls.hadwarestore.usecases.interfaces.DeleteProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteProductUseCase implements DeleteProduct {

    private final ProductsInterface productsInterface;

    @Override
    public Mono<Void> applyProduct(String id) {
        return productsInterface.deleteById(id);
    }
}
