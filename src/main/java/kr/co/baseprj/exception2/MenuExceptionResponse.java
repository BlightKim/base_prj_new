package kr.co.baseprj.exception2;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MenuExceptionResponse {
  private final HttpStatus status;
  private final String code;

  private final String target;
  private final String message;

  public MenuExceptionResponse(MenuSaveExceptionCode exceptionCode) {
    this.status = exceptionCode.getStatus();
    this.code = exceptionCode.getCode();
    this.target = exceptionCode.getTarget();
    this.message = exceptionCode.getMessage();
  }
}
