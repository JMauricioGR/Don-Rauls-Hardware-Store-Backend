package com.donrauls.hadwarestore.routes;


import com.donrauls.hadwarestore.usecases.DeleteProviderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProviderRoute {

    @Bean
    RouterFunction<ServerResponse> deleteProvider(DeleteProviderUseCase deleteProviderUseCase){
        return route(DELETE("provider/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.GONE)
                        .body(BodyInserters.fromPublisher(deleteProviderUseCase.apply(request.pathVariable("id")), Void.class)));
    }
}
