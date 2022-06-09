package com.donrauls.hadwarestore.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvidersDTO {

    private String name;
    private Number providerId;
    private String note;

}
