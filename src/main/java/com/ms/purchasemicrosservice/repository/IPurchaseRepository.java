package com.ms.purchasemicrosservice.repository;

import com.ms.purchasemicrosservice.model.PurchaseModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPurchaseRepository extends MongoRepository<PurchaseModel, String> {
    PurchaseModel findByPurchaseExternalID(UUID purchaseExternalID);
}

