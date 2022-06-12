package com.donrauls.hadwarestore.usecases.interfaces;

import com.donrauls.hadwarestore.dtos.ReceiptDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateReceipt {
    Mono<ReceiptDTO> applyReceipt(ReceiptDTO receiptDTO);
}
