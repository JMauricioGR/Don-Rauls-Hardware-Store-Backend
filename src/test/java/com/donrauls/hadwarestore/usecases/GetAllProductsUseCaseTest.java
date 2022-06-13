package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.collections.Products;
import com.donrauls.hadwarestore.dtos.BillsDTO;
import com.donrauls.hadwarestore.dtos.ProductsDTO;
import com.donrauls.hadwarestore.mappers.ProductsMapper;
import com.donrauls.hadwarestore.repositories.ProductsInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllProductsUseCaseTest {

    @Autowired
    private ProductsMapper productsMapper;

    @Mock
    ProductsInterface productsInterface;

    private GetAllProductsUseCase getAllProductsUseCase;

    @BeforeEach
    void setUp(){
        getAllProductsUseCase = new GetAllProductsUseCase(productsInterface, productsMapper);
    }

    @Test
    public void  getAllProductsTest(){

        Products product = new Products();
        product.setId("97w89frw");
        product.setProductName("name");
        product.setMaximumUnits(8);
        product.setProductDescription("description");
        product.setPrice(555);
        product.setMinimumUnits(6);

        Products product2 = new Products();
        product2.setId("97w89frw");
        product2.setProductName("name");
        product2.setMaximumUnits(8);
        product2.setProductDescription("description");
        product2.setPrice(555);
        product2.setMinimumUnits(6);

        Mockito.when(productsInterface.findAll()).thenReturn(Flux.just(product,product2));
        Flux<ProductsDTO> productsDTOFlux = getAllProductsUseCase.getAllProducts();

        StepVerifier
                .create(productsDTOFlux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(productsInterface).findAll();

    }

}