package com.microservices.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "limits-service")
public record LimitsConfiguration(int min, int max) {

}
