package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.ReceiptDTO;
import com.donrauls.hadwarestore.mappers.ReceiptMapper;
import com.donrauls.hadwarestore.repositories.ReceiptInterface;
import com.donrauls.hadwarestore.usecases.interfaces.CreateReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateReceiptUseCase implements CreateReceipt {

    @Autowired
    private ReceiptInterface receiptInterface;

    @Autowired
    private ReceiptMapper receiptMapper;

    @Override
    public Mono<ReceiptDTO> applyReceipt(ReceiptDTO receiptDTO) {
        return receiptInterface.save(receiptMapper
                .dtoToReceipt()
                .apply(receiptDTO))
                .map(receipt -> receiptMapper
                        .receiptToDTO()
                        .apply(receipt));
    }

    public CreateReceiptUseCase(ReceiptMapper receiptMapper, ReceiptInterface receiptInterface) {
        this.receiptInterface = receiptInterface;
        this.receiptMapper = receiptMapper;
    }
}
