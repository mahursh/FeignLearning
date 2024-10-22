package com.ada.githubthirdparty.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestCustomException extends RuntimeException {


    private final String description;

    public BadRequestCustomException(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
