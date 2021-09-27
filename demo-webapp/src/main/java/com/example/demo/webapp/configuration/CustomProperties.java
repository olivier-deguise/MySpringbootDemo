package com.example.demo.webapp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "com.example.demo.webapp")
@Data
public class CustomProperties {

    private String apiUrl;

}