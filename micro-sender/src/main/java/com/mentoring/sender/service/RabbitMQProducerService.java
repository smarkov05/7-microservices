package com.mentoring.sender.service;

import com.mentoring.sender.dto.MessageDto;

public interface RabbitMQProducerService {
    void publishMessage(String exchange, String routingKey, MessageDto message);
}
