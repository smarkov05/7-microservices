package com.mentoring.collector.feign;

import com.mentoring.collector.dto.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "recipient-service")
public interface RecipientFeignClient {

    @GetMapping("/api/messages")
    List<MessageDTO> getMessages();
}
