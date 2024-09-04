package com.ms.purchasemicrosservice.amqp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    // Routing Keys
    public static final String routingKeyOrderCreated = "routingKey.order.created";

    // Queues
    public static final String queueOrderCreated = "queue.order.created";

    // Exchange
    public static final String exchangeOrderCreated = "topic.exchange.order.created";

    @Bean
    public Queue filaServicoVendas() {
        return new Queue(queueOrderCreated, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeOrderCreated);
    }

    @Bean
    public Binding bindFilaServicoVendas(Queue filaServicoVendas, TopicExchange exchange) {
        return BindingBuilder.bind(filaServicoVendas).to(exchange).with(routingKeyOrderCreated);
    }
}

