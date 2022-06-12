package com.donrauls.hadwarestore.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDTO {
    private String id;
    private String providerName;
    private String date;
    private String providerId;
    private String product;
    private String quantity;
}
