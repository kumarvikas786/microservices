package com.lcwd.rating.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
