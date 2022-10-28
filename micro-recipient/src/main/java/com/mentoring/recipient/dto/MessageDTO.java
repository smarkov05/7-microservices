package com.mentoring.recipient.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageDTO implements Serializable {
    private String userName;
    private String message;
}
