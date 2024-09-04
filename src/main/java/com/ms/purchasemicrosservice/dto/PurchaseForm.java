package com.ms.purchasemicrosservice.dto;

import com.ms.purchasemicrosservice.model.PurchaseModel;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseForm {

    @NotNull
    private String clientId;

    @NotNull
    private String productId;

    @NotNull
    private Long quantity;

    public static PurchaseModel formToModel(PurchaseForm purchaseForm) {
        PurchaseModel purchaseModel = new PurchaseModel();
        purchaseModel.setClientId(purchaseForm.getClientId());
        purchaseModel.setProductId(purchaseForm.getProductId());
        purchaseModel.setQuantity(purchaseForm.getQuantity());
        return purchaseModel;
    }

    public static PurchaseDTO formToDTO(PurchaseForm purchaseForm) {
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setClientId(purchaseForm.getClientId());
        purchaseDTO.setProductId(purchaseForm.getProductId());
        purchaseDTO.setQuantity(purchaseForm.getQuantity());
        return purchaseDTO;
    }
}
