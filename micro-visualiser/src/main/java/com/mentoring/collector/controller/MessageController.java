package com.mentoring.collector.controller;

import com.mentoring.collector.dto.MessageDTO;
import com.mentoring.collector.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("saved-messages")
    public List<MessageDTO> getSavedMessages() {
        return messageService.getSavedMessages();
    }
}
