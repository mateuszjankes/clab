package com.example.Project.wikipedia.API.exception.handler;

import com.example.Project.wikipedia.API.exception.InternalServerException;
import com.example.Project.wikipedia.API.exception.response.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiException internalServerException(InternalServerException e) {
        return new ApiException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}