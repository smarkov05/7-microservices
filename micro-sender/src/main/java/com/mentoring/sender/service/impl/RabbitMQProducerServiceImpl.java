package com.mentoring.sender.service.impl;

import com.mentoring.sender.dto.MessageDto;
import com.mentoring.sender.service.RabbitMQProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;

@Service
@RequiredArgsConstructor
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publishMessage(@NotBlank(message = "Exchange key is required to publish message") String exchange,
                               @NotBlank(message = "routing key is required to publish message") String routingKey,
                               MessageDto message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
