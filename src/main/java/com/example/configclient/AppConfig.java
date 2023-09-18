package com.example.configclient;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@Data
public class AppConfig {
    private String prop1;
    private String prop2;
    private String prop3;
    private String prop4;
}
