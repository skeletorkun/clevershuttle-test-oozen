package com.example.clevershuttle.web.controller;

import com.example.clevershuttle.web.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> validationErrorHandler(NotFoundException ex) {
        return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
    }

}
