package com.flow.flowbackend.util;

import com.flow.flowbackend.exception.AlreadyExistException;
import com.flow.flowbackend.exception.CustomExtensionExceedException;
import com.flow.flowbackend.exception.NotAFixedExtensionException;
import com.flow.flowbackend.exception.NothingChangedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    protected ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(400).body("Invalid Parameter");
    }

    @ExceptionHandler(value = { CustomExtensionExceedException.class })
    protected ResponseEntity handleCustomExtensionExceedExceptionException(CustomExtensionExceedException ex) {
        return ResponseEntity.status(400).body("Custom Extension number exceed");
    }

    @ExceptionHandler(value = { NothingChangedException.class })
    protected ResponseEntity handleNothingChangedExceptionException(NothingChangedException ex) {
        return ResponseEntity.status(304).body("Nothing changed");
    }

    @ExceptionHandler(value = { NotAFixedExtensionException.class })
    protected ResponseEntity handleNotAFixedExtensionExceptionException(NotAFixedExtensionException ex) {
        return ResponseEntity.status(400).body("Not a Fixed extension");
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        return ResponseEntity.status(400).body("Custom extension name max length limit exceed");
    }

    @ExceptionHandler(value = {AlreadyExistException.class})
    protected ResponseEntity<Object> handleConstraintViolation(AlreadyExistException ex) {
        return ResponseEntity.status(304).body("already exist custom extension");
    }
}
