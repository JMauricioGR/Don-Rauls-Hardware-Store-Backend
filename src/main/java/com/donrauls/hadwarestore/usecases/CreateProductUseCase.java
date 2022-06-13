package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.ProductsDTO;
import com.donrauls.hadwarestore.mappers.ProductsMapper;
import com.donrauls.hadwarestore.repositories.ProductsInterface;
import com.donrauls.hadwarestore.usecases.interfaces.CreateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateProductUseCase implements CreateProduct {

    @Autowired
    private ProductsInterface productsInterface;
    @Autowired
    private ProductsMapper productsMapper;



    @Override
    public Mono<ProductsDTO> applyProduct(ProductsDTO productsDTO) {
        return productsInterface.save(productsMapper.dtoToProducts().apply(productsDTO)).map(product -> productsMapper.productsToDTO().apply(product));
    }
}
