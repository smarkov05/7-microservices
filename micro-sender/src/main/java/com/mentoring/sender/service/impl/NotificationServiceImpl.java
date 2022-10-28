package com.mentoring.sender.service.impl;

import com.mentoring.sender.config.RabbitMQConstants;
import com.mentoring.sender.dto.MessageDto;
import com.mentoring.sender.service.NotificationService;
import com.mentoring.sender.service.RabbitMQProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService, RabbitMQConstants {
    private final RabbitMQProducerService rabbit;

    @Override
    public void sendNotification(MessageDto message) {
        rabbit.publishMessage(MESSAGE_NOTIFICATION_EXCHANGE, CREATE_MESSAGE_ROUTING_KEY, message);
        log.info("Message was send to RabbitMQ. {}", message);
    }
}
