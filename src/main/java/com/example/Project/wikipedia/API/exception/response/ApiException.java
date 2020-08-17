package com.example.Project.wikipedia.API.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
@AllArgsConstructor
public class ApiException {

    private final String message;
    private final HttpStatus error;

}