package com.donrauls.hadwarestore.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipesDTO {

    private String id;
    private String providerName;
    private Date date;
    private String providerId;
    private List<String> products;
    private String total;
}
