package com.mentoring.recipient.controller;

import com.mentoring.recipient.dto.MessageDTO;
import com.mentoring.recipient.entity.Message;
import com.mentoring.recipient.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageRepository messageRepository;
    private final ModelMapper mapper;

    @GetMapping
    public List<MessageDTO> getMessages() {
        List<Message> messages = messageRepository.findAll(Sort.by("userName"));
        if (messages.isEmpty()) {
            log.warn("There is no messages to logging");
            return new ArrayList<>();
        }

        log.info("Get existing messages from repository: {}", messages);

        messageRepository.deleteAll(new ArrayList<>(messages));

        return messages.stream()
                .map(m -> mapper.map(m, MessageDTO.class))
                .collect(Collectors.toList());
    }
}
