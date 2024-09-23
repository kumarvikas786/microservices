package com.lcwd.user.service.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    private static final String NOT_FOUND = "Not Found";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse>  handleResourceNotFoundException(ResourceNotFoundException ex){
        var response = new ErrorResponse(HttpStatus.NOT_FOUND,404, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
