package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.ProductsDTO;
import com.donrauls.hadwarestore.dtos.mappers.ProductsMapper;
import com.donrauls.hadwarestore.repositories.ProductsInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProductsUseCase {

    private ProductsInterface productsInterface;
    private ProductsMapper productsMapper;

    public Flux<ProductsDTO> getAllProducts(){
        return productsInterface.findAll()
                .map(product -> productsMapper.productsToDTO().apply(product));
    }
}
