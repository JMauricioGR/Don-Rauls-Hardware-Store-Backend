package com.donrauls.hadwarestore.collections;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Providers {

    @Id
    private String id;
    private String name;
    private Number providerId;
    private String note;
}