package com.ada.githubthirdparty.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@Getter
@Setter

@JsonInclude(NON_NULL)
public class ApiException {

    private String description;
    private Integer status;
}
