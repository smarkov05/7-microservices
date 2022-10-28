package com.mentoring.collector.dto;

import com.mentoring.collector.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO implements Serializable {
    private String userName;
    private String message;

    public static Message toMessageEntity(MessageDTO dto) {
        return new Message(null, dto.getUserName(), dto.getMessage());
    }

    public static MessageDTO toMessageDTO(Message message) {
        return new MessageDTO(message.getUserName(), message.getMessage());
    }
}
