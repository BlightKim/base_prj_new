package kr.co.baseprj.common.exception;

import lombok.Data;

@Data
public class ErrorResponseVo {
    //결과 코드
    private String resultCode;

    //결과 메시지
    private String resultMsg;
}
