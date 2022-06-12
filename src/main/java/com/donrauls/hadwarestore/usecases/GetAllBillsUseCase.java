package com.donrauls.hadwarestore.usecases;

import com.donrauls.hadwarestore.dtos.BillsDTO;
import com.donrauls.hadwarestore.dtos.mappers.BillsMapper;
import com.donrauls.hadwarestore.repositories.BillsInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllBillsUseCase {

    private BillsMapper billsMapper;
    private BillsInterface billsInterface;

    public Flux<BillsDTO> getAllBills(){
        return billsInterface.findAll()
                .map(bill -> billsMapper
                        .billsToDTO().apply(bill));
    }
}
