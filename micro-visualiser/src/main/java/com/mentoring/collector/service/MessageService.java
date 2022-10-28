package com.mentoring.collector.service;

import com.mentoring.collector.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getSavedMessages();
}
