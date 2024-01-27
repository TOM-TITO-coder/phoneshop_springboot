package com.phoneshop.phoneshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice                      // use @ControllerAdvice for handling exception globally across the whole application  
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)           // ApiException.class is the exception that we want to handle
    public ResponseEntity<?> handleApiException(ApiException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getStatus(), e.getMessage());
        return ResponseEntity
                        .status(e.getStatus())
                        .body(errorResponse);
    }
}
