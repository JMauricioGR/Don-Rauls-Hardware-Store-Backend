package com.donrauls.hadwarestore.dtos;

import com.donrauls.hadwarestore.collections.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillsDTO {
    private String id;
    private String date;
    private String clientName;
    private String seller;
    private List<Products> products;
    private Integer total;
}
