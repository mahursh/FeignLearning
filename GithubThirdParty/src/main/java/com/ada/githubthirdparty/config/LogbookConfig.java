package com.ada.githubthirdparty.config;

import com.ada.githubthirdparty.customes.CustomSink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;



@Configuration
public class LogbookConfig {




    @Bean
    public Logbook logbook() {
        return Logbook.builder()
                .sink(new CustomSink())
                .build();
    }



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

//
//    @Bean
//    public Logbook logbook() {
////        Predicate<HttpRequest> exclude = Conditions.exclude(
////                Conditions.requestTo("/userInfo")
////        );
//
//        //DefaultSink httpSink = new DefaultSink(new DefaultHttpLogFormatter(), new DefaultHttpLogWriter());
//
//        //DefaultSink curlSink = new DefaultSink(new CurlHttpLogFormatter(), new DefaultHttpLogWriter());
//
//        DefaultSink jsonSink = new DefaultSink(new JsonHttpLogFormatter(), new DefaultHttpLogWriter());
//
//        return Logbook.builder()
//                .correlationId(new DefaultCorrelationId())
////                .condition(exclude)
//                .sink(jsonSink)
//                .build();
//    }
////
//    @Bean
//    public Logbook logbook() {
//        BinaryOperator<String> filterSecretHeader = (s1, s2)-> s1.toLowerCase().equals("x-secret") ? "<secret>" : s2;
//
//        return Logbook.builder()
//                .queryFilter(accessToken())
//                .queryFilter(replaceQuery("password", "<secret>"))
//                .headerFilter(authorization())
//                .headerFilter(eachHeader(filterSecretHeader))
//                .bodyFilter(
//                        BodyFilters.replaceJsonStringProperty(
//                                new HashSet<>(Arrays.asList("password")), "<secret>"))
//                .formatter(new JsonHttpLogFormatter())
//                .writer(new DefaultHttpLogWriter(
//                        LoggerFactory.getLogger(LogbookConfig.class),
//                        DefaultHttpLogWriter.Level.INFO))
//                .build();
//    }


}


