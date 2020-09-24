package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ParameterNotFoundException.class)
    public ResponseEntity<CommonError> handleUserNotFound(ParameterNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getError());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CommonError> handleValidationViolation(Exception ex) {
        CommonError error = CommonError.builder()
                .message(((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().get(0).getDefaultMessage())
                .status(400)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


}
