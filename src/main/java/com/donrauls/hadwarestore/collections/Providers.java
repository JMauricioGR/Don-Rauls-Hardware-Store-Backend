package com.donrauls.hadwarestore.collections;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "providers")
@Data
@AllArgsConstructor
public class Providers {

    @Id
    private String id;
    private String name;
    private String providerId;
    private String note;
}
