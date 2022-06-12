package com.donrauls.hadwarestore.dtos.mappers;

import com.donrauls.hadwarestore.collections.Products;
import com.donrauls.hadwarestore.dtos.ProductsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductsMapper {

    private ModelMapper modelMapper;

    public ProductsMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Function<Products, ProductsDTO> productsToDTO(){
        return productsDTO -> modelMapper.map(productsDTO, ProductsDTO.class);
    }

    public Function<ProductsDTO, Products> dtoToProducts(){
        return product -> modelMapper.map(product, Products.class);
    }
}
