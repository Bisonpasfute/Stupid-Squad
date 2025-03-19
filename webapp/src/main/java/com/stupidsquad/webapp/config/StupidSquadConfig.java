package com.stupidsquad.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class StupidSquadConfig {

    @Bean
    public WebClient stupidSquandWebClient() {
        return WebClient.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(10 * 1024 * 1024)) // Increase buffer size to 10MB
                .build();
    }
}
