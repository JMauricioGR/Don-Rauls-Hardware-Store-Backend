package com.donrauls.hadwarestore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "recipes")
public class Recipes {
    @Id
    private String id;
    private String providerName;
    private String date;
    private String providerId;
    private List<Products> products;
}
