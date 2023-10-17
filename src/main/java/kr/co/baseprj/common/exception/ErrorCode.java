package kr.co.baseprj.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(404,"COMMON-ERR-404","페이지를 찾을수 없습니다."),
    DUPLICATION_CODE(200,"2000","중복된 데이터가 있습니다."),
    EMPTY_CODE(200,"2001","등록 데이터가 없습니다."),
    TRANSACTION_FAIL(200,"9000","저장이 정상적으로 이뤄지지 않았습니다."),
    SYSTEM_ERROR_CODE(200,"9999","알 수 없는 시스템 오류입니다."),
    INTER_SERVER_ERROR(500,"COMMON-ERR-500","서버 작업중 오류가 발생했습니다."),
    EXCEPTION_ERROR(501,"COMMON-ERR-501","처리중 오류가 발생했습니다."),
    ;


    private int status;
    private String code;
    private String message;
}
