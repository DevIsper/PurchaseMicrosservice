package com.ms.purchasemicrosservice.dto;

import com.ms.purchasemicrosservice.model.PurchaseModel;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class PurchaseDTO {

    @NotNull
    private UUID purchaseExternalID = UUID.randomUUID();

    @NotNull
    private String clientId;

    @NotNull
    private String productId;

    @NotNull
    private Long quantity;

    public static PurchaseDTO modelToDto(PurchaseModel model) {
        PurchaseDTO dto = new PurchaseDTO();
        dto.setPurchaseExternalID(model.getPurchaseExternalID());
        dto.setClientId(model.getClientId());
        dto.setProductId(model.getProductId());
        dto.setQuantity(model.getQuantity());
        return dto;
    }

    public static PurchaseModel dtoToModel(PurchaseDTO dto) {
        PurchaseModel model = new PurchaseModel();
        model.setPurchaseExternalID(dto.getPurchaseExternalID());
        model.setClientId(dto.getClientId());
        model.setProductId(dto.getProductId());
        model.setQuantity(dto.getQuantity());
        return model;
    }


}

