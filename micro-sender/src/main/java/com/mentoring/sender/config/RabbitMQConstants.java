package com.mentoring.sender.config;

public interface RabbitMQConstants {
    String CREATE_MESSAGE_NOTIFICATION_QUEUE = "message-notification.on-create.queue";
    String MESSAGE_NOTIFICATION_DEAD_QUEUE = "message-notification.dead-letter.queue";
    String MESSAGE_NOTIFICATION_EXCHANGE = "event-notification.exchange";
    String CREATE_MESSAGE_ROUTING_KEY = "event-notification.create.rk";
}
