package com.abc.bank.mortgage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("mortgage.message")
public class MessageConfig {
    private Map<String,String> messageProperties= new HashMap<>();
}
