package com.mentoring.sender.service;

import com.mentoring.sender.dto.MessageDto;

public interface NotificationService {
    void sendNotification(MessageDto message);
}
