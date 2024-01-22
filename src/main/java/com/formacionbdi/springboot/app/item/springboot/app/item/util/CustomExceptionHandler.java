package com.formacionbdi.springboot.app.item.springboot.app.item.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, errorMessage, request.getDescription(false));
        return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    // Otros manejadores de excepciones pueden agregarse según sea necesario
}