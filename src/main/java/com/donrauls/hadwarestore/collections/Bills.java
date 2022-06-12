package com.donrauls.hadwarestore.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "bills")
public class Bills {
    @Id
    private String id;
    private String date;
    private String clientName;
    private String seller;
    private List<Products> products;
    private Integer total;
}
