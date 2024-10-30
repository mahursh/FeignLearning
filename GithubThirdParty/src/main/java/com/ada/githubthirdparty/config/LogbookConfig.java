package com.ada.githubthirdparty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.HttpRequest;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.core.Conditions;
import org.zalando.logbook.core.DefaultHttpLogFormatter;
import org.zalando.logbook.core.DefaultHttpLogWriter;
import org.zalando.logbook.core.DefaultSink;
import org.zalando.logbook.json.JsonHttpLogFormatter;

import java.util.function.Predicate;

@Configuration
public class LogbookConfig {
//    @Bean
//    public Logbook logbook() {
//        Logbook logbook = Logbook.builder()
//                .condition(Conditions.exclude(Conditions.requestTo("/api/welcome"),
//                        Conditions.contentType("application/octet-stream"),
//                        Conditions.header("X-Secret", "true")))
//                .sink(new DefaultSink(new DefaultHttpLogFormatter(), new DefaultHttpLogWriter()))
//                .build();
//        return logbook;
//    }


    @Bean
    public Logbook logbook() {
        Predicate<HttpRequest> exclude = Conditions.exclude(
                Conditions.requestTo("/repos").or(
                        Conditions.requestTo("/userInfo"))
        );

        //DefaultSink httpSink = new DefaultSink(new DefaultHttpLogFormatter(), new DefaultHttpLogWriter());

        //DefaultSink curlSink = new DefaultSink(new CurlHttpLogFormatter(), new DefaultHttpLogWriter());

        DefaultSink jsonSink = new DefaultSink(new JsonHttpLogFormatter(), new DefaultHttpLogWriter());

        return Logbook.builder()
                .condition(exclude)
                .sink(jsonSink)
                .build();
    }
}


