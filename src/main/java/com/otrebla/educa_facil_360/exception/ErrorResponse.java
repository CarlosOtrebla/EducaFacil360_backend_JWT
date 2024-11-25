package com.otrebla.educa_facil_360.exception;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
  private Map<String, String> errors;

  public ErrorResponse(Map<String, String> errors) {
    this.errors = errors;
  }

}
