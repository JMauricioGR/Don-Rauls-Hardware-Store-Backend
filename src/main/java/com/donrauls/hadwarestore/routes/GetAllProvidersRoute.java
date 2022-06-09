package com.donrauls.hadwarestore.routes;

import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import com.donrauls.hadwarestore.usecases.GetAllProvidersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class GetAllProvidersRoute {

    @Bean
    public RouterFunction<ServerResponse> allProviders(GetAllProvidersUseCase getAllProvidersUseCase){
        return route(GET("providers/all"), request-> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromPublisher(getAllProvidersUseCase.getAllProviders(), ProvidersDTO.class)));
    }
}
