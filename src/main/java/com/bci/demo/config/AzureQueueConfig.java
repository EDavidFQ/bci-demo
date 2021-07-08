package com.bci.demo.config;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.QueueClientBuilder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AzureQueueConfig {

    private static final String PROTOCOL = "DefaultEndpointsProtocol=";
    private static final String ACCOUNT_NAME = "AccountName=";
    private static final String ACCOUNT_KEY = "AccountKey=";
    private static final String ENDPOINT_SUFFIX = "EndpointSuffix=";

    private final ApplicationProperties applicationProperties;

    @Bean
    public QueueClient buildQueueClient() {
        return new QueueClientBuilder()
                .connectionString(this.buildConnectionString())
                .queueName(applicationProperties.getQueueName())
                .buildClient();
    }

    private String buildConnectionString() {
        StringBuilder connectionString = new StringBuilder();
        connectionString.append(PROTOCOL).append(applicationProperties.getProtocol()).append(";");
        connectionString.append(ACCOUNT_NAME).append(applicationProperties.getAccountName()).append(";");
        connectionString.append(ACCOUNT_KEY).append(applicationProperties.getAccountKey()).append(";");
        connectionString.append(ENDPOINT_SUFFIX).append(applicationProperties.getEndpointSuffix());

        return connectionString.toString();
    }

}
