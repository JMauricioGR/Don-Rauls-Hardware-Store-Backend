package com.donrauls.hadwarestore.dtos.mappers;

import com.donrauls.hadwarestore.collections.Providers;
import com.donrauls.hadwarestore.dtos.ProvidersDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProviderMapper {

    private ModelMapper modelMapper;

    public ProviderMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Function<Providers, ProvidersDTO> providerToDTO(){
        return providerDTO -> modelMapper.map(providerDTO, ProvidersDTO.class);
    }

    public Function<ProvidersDTO, Providers> dtoToProvider(){
        return provider -> modelMapper.map(provider, Providers.class);
    }
}
