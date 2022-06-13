package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.collections.Receipt;
import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import com.donrauls.hadwarestore.dtos.ReceiptDTO;
import com.donrauls.hadwarestore.mappers.ProviderMapper;
import com.donrauls.hadwarestore.mappers.ReceiptMapper;
import com.donrauls.hadwarestore.repositories.ProvidersInterface;
import com.donrauls.hadwarestore.repositories.ReceiptInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllReceiptUseCaseTest {
    @Autowired
    private ReceiptMapper receiptMapper;

    @Mock
    ReceiptInterface receiptInterface;

    private GetAllReceiptUseCase getAllReceiptUseCase;

    @BeforeEach
    void setUp() {
        getAllReceiptUseCase = new GetAllReceiptUseCase(receiptMapper, receiptInterface);
    }

    @Test
    public void getAllReceiptTest(){


        Receipt receipt = new Receipt();
        receipt.setId("10921n13987b9879nm1");
        receipt.setDate("2022-08-21");
        receipt.setProviderName("Name");
        receipt.setProviderId("Id");
        receipt.setProduct("product");
        receipt.setQuantity("432");



        Mockito.when(receiptInterface.findAll()).thenReturn(Flux.just(receipt));
        Flux<ReceiptDTO> receiptDTOFlux = getAllReceiptUseCase.getAllReceipts();

        StepVerifier
                .create(receiptDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(receiptInterface).findAll();
    }
}