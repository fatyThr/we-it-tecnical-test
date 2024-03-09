package com.technical.test.weitproject.infrastructure.exceptions;


import com.technical.test.weitproject.infrastructure.utils.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;
@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
        log.error(e.getMessage());
        var errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR", "Internal server error occurred.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<ErrorResponse> handleTechnicalException(TechnicalException t) {
        log.error(t.getMessage());
        String message = messageSource.getMessage(t.getCode(), t.getParams(), Locale.getDefault());
        var errorResponse = new ErrorResponse(t.getCode(), message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
