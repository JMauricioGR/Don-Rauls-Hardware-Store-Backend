package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.ProductsDTO;
import com.donrauls.hadwarestore.dtos.mappers.ProductsMapper;
import com.donrauls.hadwarestore.repositories.ProductsInterface;
import com.donrauls.hadwarestore.usecases.interfaces.UpdateProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UpdateProductUseCase implements UpdateProduct {

    private final ProductsInterface productsInterface;
    private final ProductsMapper productsMapper;

    @Override
    public Mono<ProductsDTO> applyProduct(String id, ProductsDTO productsDTO) {
        return productsInterface.findById(id).flatMap(product ->{
            productsDTO.setId(product.getId());
            return productsInterface.save(productsMapper.dtoToProducts().apply(productsDTO)).map(productres-> productsMapper.productsToDTO().apply(productres));
        }).switchIfEmpty(Mono.just(new ProductsDTO()));
    }
}
