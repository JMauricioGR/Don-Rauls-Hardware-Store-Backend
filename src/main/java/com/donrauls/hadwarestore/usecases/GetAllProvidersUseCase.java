package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import com.donrauls.hadwarestore.mappers.ProviderMapper;
import com.donrauls.hadwarestore.repositories.ProvidersInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProvidersUseCase {

    private ProviderMapper providerMapper;
    private ProvidersInterface providersInterface;


    public Flux<ProvidersDTO> getAllProviders(){
        return providersInterface.findAll()
                .map(provider -> providerMapper.providerToDTO().apply(provider));
    }
}
