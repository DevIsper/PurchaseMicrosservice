package com.ms.purchasemicrosservice.amqp.producer;

import com.ms.purchasemicrosservice.amqp.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendSalesMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.exchangeOrderCreated, message);
    }

    public void sendNewSaleMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.exchangeOrderCreated, RabbitMQConfig.routingKeyOrderCreated, message);
    }
}

