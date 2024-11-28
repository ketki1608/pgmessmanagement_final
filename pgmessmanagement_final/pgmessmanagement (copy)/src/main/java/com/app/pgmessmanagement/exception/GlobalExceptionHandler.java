package com.app.pgmessmanagement.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgsNotValidException(MethodArgumentNotValidException ex) {
        log.error("Inside handleMethodArgsNotValidException() method ");
        return new ResponseEntity<>(ex.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ResourceFoundException.class)
    public ResponseEntity<?> resourceFoundException(ResourceFoundException ex) {
        log.error(ex.getMessage()+ ex.getLocalizedMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalExceptionHandler(Exception ex) {
        log.error("Inside globalExceptionHandler() method  : General Exception Occurs "+ex.getMessage());
        return new ResponseEntity<>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
