package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.collections.Bills;
import com.donrauls.hadwarestore.collections.Products;
import com.donrauls.hadwarestore.dtos.BillsDTO;
import com.donrauls.hadwarestore.mappers.BillsMapper;
import com.donrauls.hadwarestore.repositories.BillsInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllBillsUseCaseTest {

    @Autowired
    private BillsMapper billsMapper;

    @Mock
    BillsInterface billsInterface;

    private GetAllBillsUseCase getAllBillsUseCase;

    @BeforeEach
    void setUp() {
        getAllBillsUseCase = new GetAllBillsUseCase(billsMapper, billsInterface);
    }

    @Test
    void getAllBillsTest(){

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

        List<Products> products = new ArrayList<>();
        products.add(product);
        products.add(product2);

        Bills bills = new Bills();
        bills.setClientName("Clien name");
        bills.setDate("2022-11-30");
        bills.setId("7we32j3r4i3");
        bills.setProducts(products);
        bills.setSeller("Seller name");
        bills.setTotal(8);

        Mockito.when(billsInterface.findAll()).thenReturn(Flux.just(bills));
        Flux<BillsDTO> billsDTOFlux = getAllBillsUseCase.getAllBills();

        StepVerifier
                .create(billsDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(billsInterface).findAll();

    }
}