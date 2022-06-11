package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.mappers.ProviderMapper;
import com.donrauls.hadwarestore.repositories.ProvidersInterface;
import com.donrauls.hadwarestore.usecases.interfaces.DeleteProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteProviderUseCase implements DeleteProvider {

    private final ProvidersInterface providersInterface;

    @Override
    public Mono<Void> apply(String id){
        return providersInterface.deleteById(id);
    }

}
