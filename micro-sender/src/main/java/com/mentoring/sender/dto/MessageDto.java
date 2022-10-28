package com.mentoring.sender.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class MessageDto implements Serializable {
    @NotBlank
    @Size(min = 3, max = 40, message = "Name and last name are required. Min length = 3. Max length = 40")
    private final String userName;
    @NotBlank
    @Size(min = 5, max = 255, message = "Message is required. Min length = 5. Max length = 255")
    private final String message;
}

