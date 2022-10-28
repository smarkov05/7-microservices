package com.mentoring.recipient.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("message")
public class Message {
    private String id;

    private String userName;
    private String message;
}
