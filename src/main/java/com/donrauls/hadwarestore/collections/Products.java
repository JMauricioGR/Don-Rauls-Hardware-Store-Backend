package com.donrauls.hadwarestore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Products")
public class Products {
    @Id
    private String id;
    private String productName;
    private String productDescription;
    private Integer minimumUnits;
    private Integer maximumUnits;
    private String provider;
    private Integer stock;
    private Integer price;

}
