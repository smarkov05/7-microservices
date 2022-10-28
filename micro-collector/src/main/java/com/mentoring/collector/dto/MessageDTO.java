package com.mentoring.collector.dto;

import com.mentoring.collector.entity.Message;
import lombok.Data;

import java.io.Serializable;

@Data
public class MessageDTO implements Serializable {
    private String userName;
    private String message;

    public static Message toMessageEntity(MessageDTO dto) {
        return new Message(null, dto.getUserName(), dto.getMessage());
    }
}
