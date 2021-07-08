package com.bci.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.azure.queue-storage")
@Getter
@Setter
public class ApplicationProperties {

    private String protocol;
    private String accountName;
    private String accountKey;
    private String endpointSuffix;
    private String queueName;

}
