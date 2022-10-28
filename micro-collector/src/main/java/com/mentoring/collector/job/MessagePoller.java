package com.mentoring.collector.job;

import com.mentoring.collector.dto.MessageDTO;
import com.mentoring.collector.entity.Message;
import com.mentoring.collector.feign.RecipientFeignClient;
import com.mentoring.collector.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessagePoller {
    private final RecipientFeignClient recipientFeignClient;
    private final MessageRepository messageRepository;

    @Scheduled(fixedDelay = 10_000L)
    public void pollMessages() {
        List<MessageDTO> messages = recipientFeignClient.getMessages();
        if (messages.isEmpty()) {
            log.warn("There is no messages to logging");
            return;
        }
        List<Message> toSave = messages.stream()
                .map(MessageDTO::toMessageEntity)
                .collect(Collectors.toList());
        messageRepository.saveAll(toSave);
        log.info("{} messages was fetched from feign client: {}", messages.size(), messages);
    }
}
