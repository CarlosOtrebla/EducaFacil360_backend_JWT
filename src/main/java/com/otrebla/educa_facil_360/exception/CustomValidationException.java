package com.otrebla.educa_facil_360.exception;

import java.util.Map;
import lombok.Getter;

@Getter
public class CustomValidationException extends RuntimeException {
  private final Map<String, String> errors;

  public CustomValidationException(Map<String, String> errors) {
    super("Validation failed");
    this.errors = errors;
  }

}
