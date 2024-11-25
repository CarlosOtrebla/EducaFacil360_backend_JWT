package com.otrebla.educa_facil_360.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomValidationException.class)
  public ResponseEntity<ErrorResponse> handleValidationException(CustomValidationException ex) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getErrors());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
}
