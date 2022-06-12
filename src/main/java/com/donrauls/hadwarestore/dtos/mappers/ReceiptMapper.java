package com.donrauls.hadwarestore.dtos.mappers;

import com.donrauls.hadwarestore.collections.Receipt;
import com.donrauls.hadwarestore.dtos.ReceiptDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ReceiptMapper {

    private ModelMapper modelMapper;

    public ReceiptMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Function<Receipt, ReceiptDTO> receiptToDTO(){
        return  receiptDTO -> modelMapper.map(receiptDTO, ReceiptDTO.class);
    }

    public Function<ReceiptDTO, Receipt> dtoToReceipt(){
        return  receipt -> modelMapper.map(receipt, Receipt.class);
    }
}
