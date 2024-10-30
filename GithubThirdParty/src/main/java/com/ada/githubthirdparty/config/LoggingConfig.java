package com.ada.githubthirdparty.config;


import com.ada.logginglib.filter.LoggingFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;


@Configuration
public class LoggingConfig {


    @Bean
    public LoggingFilter loggingFilter(ObjectMapper objectMapper) {
        LoggingFilter loggingFilter = new LoggingFilter(objectMapper);


//        loggingFilter.setLogFormat("ISO27001");

        return loggingFilter;
    }
}
