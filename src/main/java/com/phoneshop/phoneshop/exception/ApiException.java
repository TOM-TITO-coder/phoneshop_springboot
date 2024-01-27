package com.phoneshop.phoneshop.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor                           // use @RequiredArgsConstructor for final fields
public class ApiException extends RuntimeException{
    private final HttpStatus status;               // use final to make sure that the value of status and message cannot be changed
    private final String message;
}
