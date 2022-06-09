package com.donrauls.hadwarestore.usecases.interfaces;

import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateProvider {
    Mono<ProvidersDTO> apply (ProvidersDTO providersDTO);
}
