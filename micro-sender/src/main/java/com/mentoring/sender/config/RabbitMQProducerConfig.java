package com.mentoring.sender.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQProducerConfig implements RabbitMQConstants {


    @Bean
    public Queue createEventNotificationQueue() {
        return new Queue(CREATE_MESSAGE_NOTIFICATION_QUEUE, true, false, false, deadLetterQueueArgs());
    }

    @Bean
    public Queue deadLetterEventNotificationQueue() {
        return new Queue(MESSAGE_NOTIFICATION_DEAD_QUEUE, true, false, false);
    }

    @Bean
    public Exchange messageNotificationExchange() {
        return ExchangeBuilder
                .topicExchange(MESSAGE_NOTIFICATION_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    public Binding createEventNotificationBinding() {
        return BindingBuilder
                .bind(createEventNotificationQueue())
                .to(messageNotificationExchange())
                .with(CREATE_MESSAGE_ROUTING_KEY)
                .noargs();
    }

    private Map<String, Object> deadLetterQueueArgs() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "");
        args.put("x-dead-letter-routing-key", MESSAGE_NOTIFICATION_DEAD_QUEUE);
        return args;
    }
}
