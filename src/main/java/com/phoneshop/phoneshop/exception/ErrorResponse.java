package com.phoneshop.phoneshop.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor               // use @AllArgsConstructor for all fields
public class ErrorResponse {      // this class for handling error response
    private HttpStatus status;
    private String message;
}
