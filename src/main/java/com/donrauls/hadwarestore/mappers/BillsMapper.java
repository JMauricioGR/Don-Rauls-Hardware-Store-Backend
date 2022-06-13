package com.donrauls.hadwarestore.mappers;

import com.donrauls.hadwarestore.collections.Bills;
import com.donrauls.hadwarestore.dtos.BillsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BillsMapper {

    private ModelMapper modelMapper;

    public BillsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Function<Bills, BillsDTO> billsToDTO(){
        return billsDTO -> modelMapper.map(billsDTO, BillsDTO.class);
    }

    public Function<BillsDTO, Bills> dtoToBills(){
        return bill -> modelMapper.map(bill, Bills.class);
    }
}
