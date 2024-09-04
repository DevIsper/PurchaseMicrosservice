package com.ms.purchasemicrosservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "tb_vendas")
public class PurchaseModel {

    @Id
    private String purchaseId;

    @Field
    @Indexed(unique = true)
    private UUID purchaseExternalID;

    @Field
    @Indexed
    private String clientId;

    @Field
    private String productId;

    @Field
    private Long sellTotalCost;

    @Field
    private Long quantity;

    @Field
    private final LocalDateTime dateTimeSell = LocalDateTime.now();
}
