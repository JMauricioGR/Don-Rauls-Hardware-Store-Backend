package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.ReceiptDTO;
import com.donrauls.hadwarestore.mappers.ReceiptMapper;
import com.donrauls.hadwarestore.repositories.ReceiptInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllReceiptUseCase {

    private ReceiptMapper receiptMapper;
    private ReceiptInterface receiptInterface;

    public Flux<ReceiptDTO> getAllReceipts(){
        return receiptInterface.findAll()
                .map(recipe -> receiptMapper.receiptToDTO().apply(recipe));
    }
}
