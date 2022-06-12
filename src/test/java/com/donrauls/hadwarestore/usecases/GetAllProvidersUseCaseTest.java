package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.collections.Providers;
import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import com.donrauls.hadwarestore.dtos.mappers.ProviderMapper;
import com.donrauls.hadwarestore.repositories.ProvidersInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.security.Provider;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class GetAllProvidersUseCaseTest {


    private GetAllProvidersUseCase getAllProvidersUseCase;

    @Autowired
    private ProviderMapper providerMapper;

    @Mock
    ProvidersInterface providersInterface;

    @BeforeEach
    void setUp() {
        getAllProvidersUseCase = new GetAllProvidersUseCase(providerMapper, providersInterface);
    }


    @Test
    public void getAllProvidersTest (){

        Providers provider = new Providers("sjinfiu335t223442344", "provider name", "provider id 12345", "note of provider");

        ProvidersDTO providersDTO = new ProvidersDTO();
        providersDTO.setId(provider.getId());
        providersDTO.setName(provider.getName());
        providersDTO.setProviderId(provider.getProviderId());
        providersDTO.setNote(provider.getNote());


        Mockito.when(providersInterface.findAll()).thenReturn(Flux.just(provider));

        Flux<ProvidersDTO> publisher = getAllProvidersUseCase.getAllProviders();

        StepVerifier.create(publisher).expectNext(providersDTO).verifyComplete();

        Mockito.verify(providersInterface.findAll());

    }

}