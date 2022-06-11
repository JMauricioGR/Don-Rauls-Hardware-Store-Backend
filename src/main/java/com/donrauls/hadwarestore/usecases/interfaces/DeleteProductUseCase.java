package com.donrauls.hadwarestore.usecases.interfaces;

import com.donrauls.hadwarestore.mappers.ProductsMapper;
import com.donrauls.hadwarestore.mappers.ProviderMapper;
import com.donrauls.hadwarestore.repositories.ProductsInterface;
import com.donrauls.hadwarestore.repositories.ProvidersInterface;
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
