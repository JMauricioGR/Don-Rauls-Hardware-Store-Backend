package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.collections.Providers;
import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import com.donrauls.hadwarestore.mappers.ProviderMapper;
import com.donrauls.hadwarestore.repositories.ProvidersInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllProvidersUseCaseTest {


    @Autowired
    private ProviderMapper providerMapper;

    @Mock
    ProvidersInterface providersInterface;

    private GetAllProvidersUseCase getAllProvidersUseCase;

    @BeforeEach
    void setUp() {
        getAllProvidersUseCase = new GetAllProvidersUseCase(providerMapper, providersInterface);
    }

    @Test
    void getAllBillsTest(){

        Providers provider = new Providers();
        provider.setId("98fr894rf");
        provider.setProviderId("iouriwequ43");
        provider.setName("ioerwfuif");
        provider.setNote("ijfoijeirfijf");



        Mockito.when(providersInterface.findAll()).thenReturn(Flux.just(provider));
        Flux<ProvidersDTO> providerDTOFlux = getAllProvidersUseCase.getAllProviders();

        StepVerifier
                .create(providerDTOFlux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(providersInterface).findAll();
    }
}