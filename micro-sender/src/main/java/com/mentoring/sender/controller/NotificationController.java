package com.mentoring.sender.controller;

import com.mentoring.sender.dto.MessageDto;
import com.mentoring.sender.service.NotificationService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

//    @Timed(value = "createMessage.time", description = "Time spend to create message")
    @Timed
    @PostMapping
    public void createMessage(@Valid @RequestBody MessageDto message){
        log.info("Created message: {}", message);
        notificationService.sendNotification(message);
    }
}
