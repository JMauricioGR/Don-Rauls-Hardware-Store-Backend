package com.donrauls.hadwarestore.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
    private String id;
    private String productName;
    private String productDescription;
    private Integer minimumUnits;
    private Integer maximumUnits;
    private String provider;
    private Integer stock;
}
