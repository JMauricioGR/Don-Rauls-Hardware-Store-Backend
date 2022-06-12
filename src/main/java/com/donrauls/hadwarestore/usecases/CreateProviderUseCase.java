package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import com.donrauls.hadwarestore.dtos.mappers.ProviderMapper;
import com.donrauls.hadwarestore.repositories.ProvidersInterface;
import com.donrauls.hadwarestore.usecases.interfaces.CreateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateProviderUseCase implements CreateProvider {

    @Autowired
    private ProvidersInterface providersInterface;

    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public Mono<ProvidersDTO> apply(ProvidersDTO providerDTO){
        return providersInterface.save(providerMapper
                .dtoToProvider()
                .apply(providerDTO))
                .map(provider -> providerMapper
                        .providerToDTO()
                        .apply(provider));
    }
}
