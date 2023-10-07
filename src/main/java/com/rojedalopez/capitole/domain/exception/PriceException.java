package com.rojedalopez.capitole.domain.exception;

public class PriceException extends RuntimeException {
  public PriceException(String code, String message, Throwable cause) {
    super(code.concat("-").concat(message), cause);
  }

  public PriceException(String code, String message) {
    super(code.concat("-").concat(message));
  }
}
