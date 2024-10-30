//package com.ada.githubthirdparty.customes;
//
//import org.zalando.logbook.*;
//
//
//import java.util.Optional;
//
//public class CustomHttpLogFormatter implements HttpLogFormatter {
//
//
//
//    @Override
//    public String format(Precorrelation precorrelation, HttpRequest request) {
//        Optional<String> userHeader = request.getHeaders().get("X-User-Id").stream().findFirst();
//        String user = userHeader.orElse("Unknown User");
//
//        String serviceName = "YourServiceName";
//        String method = request.getMethod();
//        String timestamp = String.valueOf(System.currentTimeMillis());
//
//        return String.format("Request: User: %s, Service: %s, Time: %s, Method: %s, Path: %s",
//                user, serviceName, timestamp, method, request.getPath());
//    }
//
//    @Override
//    public String format(Correlation correlation, HttpResponse response) {
//        int status = response.getStatus();
//        String reason = response.getReasonPhrase();
//
//        return String.format("Response: Status: %d, Reason: %s", status, reason);
//    }
//
//}
