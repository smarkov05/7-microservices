package com.mentoring.collector.service;

import com.mentoring.collector.dto.MessageDTO;
import com.mentoring.collector.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    public List<MessageDTO> getSavedMessages() {
        return messageRepository.findAll().stream()
                .map(MessageDTO::toMessageDTO)
                .collect(Collectors.toList());
    }
}
