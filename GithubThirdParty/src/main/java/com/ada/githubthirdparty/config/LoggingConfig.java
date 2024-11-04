package com.ada.githubthirdparty.config;


import com.ada.logginglib.filter.LoggingFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Set;


@Configuration
public class LoggingConfig {


    @Bean
    public LoggingFilter loggingFilter(ObjectMapper objectMapper) {
        LoggingFilter loggingFilter = new LoggingFilter(objectMapper);

        loggingFilter.setIgnoredPaths(Set.of("/health", "/info", "/userInfo/.*"));

        loggingFilter.setExcludedBodyPaths(Set.of("/login", "/register"));

        loggingFilter.setLogFormat("JSON");

        loggingFilter.setMaskingRules(Map.of(
                "(?i)url", "*****",
                "(?i)creditCard", "####-####-####"
        ));

        return loggingFilter;
    }
}
