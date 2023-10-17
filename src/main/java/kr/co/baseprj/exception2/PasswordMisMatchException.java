package kr.co.baseprj.exception2;

public class PasswordMisMatchException extends RuntimeException {

  public PasswordMisMatchException(String message) {
    super(message);
  }
}
