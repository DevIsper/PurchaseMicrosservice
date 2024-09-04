package com.ms.purchasemicrosservice.controller;

import com.ms.purchasemicrosservice.dto.PurchaseDTO;
import com.ms.purchasemicrosservice.dto.PurchaseForm;
import com.ms.purchasemicrosservice.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(path = "/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(path = "/newPurchase")
    public ResponseEntity<PurchaseDTO> createPurchase(@Valid @RequestBody PurchaseForm form) {
        PurchaseDTO dto = purchaseService.save(PurchaseForm.formToDTO(form));
        return ResponseEntity.ok().body(dto);
    }
}
