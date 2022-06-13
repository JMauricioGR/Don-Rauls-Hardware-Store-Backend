package com.donrauls.hadwarestore.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "receipt")
public class Receipt {
    @Id
    private String id;
    private String providerName;
    private String date;
    private String providerId;
    private String product;
    private String quantity;
}
