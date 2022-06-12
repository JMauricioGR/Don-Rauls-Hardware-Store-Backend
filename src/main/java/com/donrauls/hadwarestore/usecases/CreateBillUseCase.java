package com.donrauls.hadwarestore.usecases.interfaces;

import com.donrauls.hadwarestore.dtos.BillsDTO;
import com.donrauls.hadwarestore.mappers.BillsMapper;
import com.donrauls.hadwarestore.repositories.BillsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateBillUseCase implements CreateBill{
    @Autowired
    private BillsInterface billsInterface;

    @Autowired
    private BillsMapper billsMapper;

    @Override
    public Mono<BillsDTO> applyBill(BillsDTO billsDTO) {
        return billsInterface.save(billsMapper
                .dtoToBills()
                .apply(billsDTO))
                .map(bill -> billsMapper
                        .billsToDTO().apply(bill));
    }
}
