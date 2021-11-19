package com.dot.technicaltest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<GlobalResponseEntity> handleNotFoundException() {
        return GlobalResponseEntity.error("404", "Data not Found", "", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GlobalResponseEntity> handleBadRequestException(BadRequestException ex) {
        return GlobalResponseEntity.error("400", ex.getMessage(), "", HttpStatus.NOT_FOUND);
    }
}
