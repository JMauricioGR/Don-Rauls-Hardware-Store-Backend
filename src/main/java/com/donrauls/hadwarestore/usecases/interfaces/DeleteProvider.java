package com.donrauls.hadwarestore.usecases.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteProvider {
    Mono<Void> apply(String id);
}
