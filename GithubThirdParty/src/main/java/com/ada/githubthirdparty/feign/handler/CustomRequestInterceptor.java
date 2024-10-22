package com.ada.githubthirdparty.feign.handler;

import com.ada.githubthirdparty.model.SuccessEntity;
import com.ada.githubthirdparty.repository.SuccessRepository;
import feign.Client;
import feign.Request;
import feign.Response;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class CustomRequestInterceptor extends Client.Default {

    @Autowired
    private SuccessRepository repository;

    public CustomRequestInterceptor() {
        super(null, null);
    }


    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        Response response = super.execute(request, options);
        String responseBody = IOUtils.toString(response.body().asInputStream());
        String requestBody = new String(request.body());

        if (HttpStatus.OK.value() == response.status() || HttpStatus.CREATED.value() == response.status()) {
            SuccessEntity successEntity = new SuccessEntity(requestBody, responseBody, response.status(),
                    LocalDateTime.now());

            this.repository.save(successEntity);
        }

        return response.toBuilder().body(responseBody, StandardCharsets.UTF_8).build();
    }
}
