package com.lcwd.rating.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private final String dateTime = LocalDateTime.now().toString();
    private HttpStatus status;
    private Integer errorCode;
    private String message;

    public ErrorResponse(HttpStatus status,Integer errorCode,String message){
        this.status=status;
        this.errorCode=errorCode;
        this.message=message;
    }

}
