package com.mentoring.recipient.rabbit;

import com.mentoring.recipient.dto.MessageDTO;
import com.mentoring.recipient.entity.Message;
import com.mentoring.recipient.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {
    private static final String CREATE_MESSAGE_NOTIFICATION_QUEUE = "message-notification.on-create.queue";

    private final ModelMapper mapper;
    private final MessageRepository messageRepository;

    @RabbitListener(queues = CREATE_MESSAGE_NOTIFICATION_QUEUE)
    public void onCreateMessageNotification(@Payload MessageDTO messageDTO) {
        log.info("Consumed messages from queue {}, Message: {}", CREATE_MESSAGE_NOTIFICATION_QUEUE, messageDTO);

        Message toSave = mapper.map(messageDTO, Message.class);
        messageRepository.save(toSave);
    }
}
