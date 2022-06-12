package com.donrauls.hadwarestore.usecases.interfaces;

import com.donrauls.hadwarestore.dtos.BillsDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateBill {
    Mono<BillsDTO> applyBill(BillsDTO billsDTO);
}
