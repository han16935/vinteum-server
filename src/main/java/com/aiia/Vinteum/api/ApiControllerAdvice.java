package com.aiia.Vinteum.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> illegalArgumentExceptionHandle(IllegalArgumentException e){
        return ApiResponse.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> bindExceptionHandle(BindException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ApiResponse.fail(HttpStatus.BAD_REQUEST, objectError.getDefaultMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> internalServerExceptionHandle(Exception e){
        e.printStackTrace();
        return ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
