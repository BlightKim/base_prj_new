package kr.co.baseprj.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -38609507860378081L;

    private ErrorCode errorCode;

    public BizException(ErrorCode errorCode){
        super("");
        this.errorCode = errorCode;
    }

    public BizException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public void printStackTrace(PrintStream s) {
        synchronized (s) {
            printStackTrace(new PrintWriter(s));
        }
    }

    public void printStackTrace(PrintWriter s) {
        synchronized (s) {
            s.println(this);
            s.println("\t-------------------------------------------------------------------------");
            s.println("\t" + errorCode.getCode() + ":" + errorCode.getMessage());
            s.println("\t-------------------------------------------------------------------------");
            StackTraceElement[] trace = getStackTrace();
            for (int i=0; i < trace.length; i++)
                s.println("\tat " + trace[i]);

            Throwable ourCause = getCause();
            if (ourCause != null) {
                ourCause.printStackTrace(s);
            }
            s.flush();
        }
    }



}
