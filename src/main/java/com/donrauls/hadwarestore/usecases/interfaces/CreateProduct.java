package com.donrauls.hadwarestore.usecases.interfaces;

import com.donrauls.hadwarestore.dtos.ProductsDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateProduct {
    Mono<ProductsDTO> applyProduct (ProductsDTO productsDTO);
}
