package com.ada.githubthirdparty.feign.handler;

import com.ada.githubthirdparty.exceptions.BadRequestCustomException;
import com.ada.githubthirdparty.model.ErrorEntity;
import com.ada.githubthirdparty.repository.ErrorRepository;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Autowired
    private  ErrorRepository repository;


    @Override
    public Exception decode(String s, Response response) {
        String requestBody = new String(response.request().body());
        String responseBody = getResponseBody(response.body());

        ErrorEntity errorEntity = new ErrorEntity(requestBody, responseBody, response.status(), LocalDateTime.now());

        this.repository.save(errorEntity);

        if (response.status() == HttpStatus.BAD_REQUEST.value()) {
            throw new BadRequestCustomException("Bad request");
        }

        throw new RuntimeException("other exception");

    }

    private String getResponseBody(Response.Body body) {
        try {
            return StreamUtils.copyToString(body.asInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
