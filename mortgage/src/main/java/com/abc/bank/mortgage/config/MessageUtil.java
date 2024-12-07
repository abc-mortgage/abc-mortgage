package com.abc.bank.mortgage.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageUtil {
    private final MessageConfig message;
    public String getMessages(String key){
        log.info("retrieving"+key);
       return message.getMessageProperties().get(key);
    }
}
