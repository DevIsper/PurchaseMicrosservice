package com.ms.purchasemicrosservice.service;

import com.ms.purchasemicrosservice.amqp.producer.SalesMessageProducer;
import com.ms.purchasemicrosservice.dto.PurchaseDTO;
import com.ms.purchasemicrosservice.model.PurchaseModel;
import com.ms.purchasemicrosservice.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private IPurchaseRepository vendaRepository;

    @Autowired
    private SalesMessageProducer salesMessageProducer;

    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        vendaRepository.save(PurchaseDTO.dtoToModel(purchaseDTO));
        salesMessageProducer.sendNewSaleMessage(purchaseDTO.getClientId() + ":" + purchaseDTO.getPurchaseExternalID());
        return purchaseDTO;
    }

    public List<PurchaseDTO> findAll() {
        List<PurchaseModel> l = vendaRepository.findAll();
        return l.stream().map(PurchaseDTO::modelToDto).toList();
    }

    public PurchaseDTO findById(String id) {
        return vendaRepository.findById(id).map(PurchaseDTO::modelToDto).orElse(null);
    }

    public void DeleteById(String id) {
        vendaRepository.deleteById(id);
    }
}
