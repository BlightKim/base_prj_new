package kr.co.baseprj.common.exception;


import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.baseprj.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String LOG_HEADER = "[공통 에러 처리] ";

    @Value("${spring.profiles.active:}") private String activeProfile;


    @ExceptionHandler(BizException.class)
    public String rbayExceptionHandler(HttpServletRequest request, HttpServletResponse response, Model model, BizException e) throws Exception {

//        log.error(LOG_HEADER + "rbayExceptionHandler 오류 발생 getMessage : " + e.getMessage());
//        log.error(LOG_HEADER + "rbayExceptionHandler 오류 발생 getLocalizedMessage : " + e.getLocalizedMessage());
        log.error(LOG_HEADER + "bizExceptionHandler 오류 발생 toString : " + e.toString());
        log.error(LOG_HEADER + "bizExceptionHandler 오류 발생 activeProfile : " + activeProfile);

//        log.error(LOG_HEADER + "rbayExceptionHandler HttpServletRequest : " + request.toString());
//        Enumeration<String> em = request.getHeaderNames();
//        while(em.hasMoreElements()) {
//            String s = em.nextElement();
//            log.error(LOG_HEADER + "rbayExceptionHandler HttpServletRequest : " + request.getHeader(s));
//        }

//        log.error(LOG_HEADER + "rbayExceptionHandler HttpServletResponse : " + response.toString());
//        log.error(LOG_HEADER + "rbayExceptionHandler isAjax : " + isAjax(request));


        String errorMessage = "";
        if(StringUtils.isEmpty(e.getMessage())){
            errorMessage = e.getErrorCode().getMessage();
        }else{
            errorMessage = e.getMessage();
        }
        e.printStackTrace();


        if(isAjax(request)){
            log.error(LOG_HEADER + "bizExceptionHandler ajax 요청 처리 시작");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            ErrorResponseVo errorResponseVo = new ErrorResponseVo();
            errorResponseVo.setResultCode(e.getErrorCode().getCode());
            errorResponseVo.setResultMsg(errorMessage);
            //writer.write(new Gson().toJson(errorResponseVo));
//            log.error(LOG_HEADER + "rbayExceptionHandler new Gson().toJson(errorResponseVo) : " + new Gson().toJson(errorResponseVo));
            //
//            writer.write(JSON.toJSONString(Result.errorOf(HttpStatus.NOT_FOUND.value(), e.getMessage())));
            //
            writer.flush();
            writer.close();
            log.error(LOG_HEADER + "bizExceptionHandler ajax 요청 처리 종료");

            return null;
        }else{
            log.error(LOG_HEADER + "bizExceptionHandler 일반 요청 처리 시작");
            model.addAttribute("errorStatus", e.getErrorCode().getStatus());
            model.addAttribute("errorCode", e.getErrorCode().getCode());
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("activeProfile", activeProfile);
            model.addAttribute("exception", e);

            return "common/error/error";
        }
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Model model, Exception e) throws Exception {

//        log.error(LOG_HEADER + "exceptionHandler 오류 발생 getMessage : " + e.getMessage());
//        log.error(LOG_HEADER + "exceptionHandler 오류 발생 getLocalizedMessage : " + e.getLocalizedMessage());
        log.error(LOG_HEADER + "exceptionHandler 오류 발생 toString : " + e.toString());
        log.error(LOG_HEADER + "exceptionHandler 오류 발생 activeProfile : " + activeProfile);


//        log.error(LOG_HEADER + "exceptionHandler HttpServletRequest : " + request.toString());
//        Enumeration<String> em = request.getHeaderNames();
//        while(em.hasMoreElements()) {
//            String s = em.nextElement();
//            log.error(LOG_HEADER + "exceptionHandler HttpServletRequest : " + request.getHeader(s));
//        }
//        log.error(LOG_HEADER + "exceptionHandler HttpServletResponse : " + response.toString());

//        log.error(LOG_HEADER + "exceptionHandler isAjax : " + isAjax(request));
        e.printStackTrace();

        ErrorCode errorCode = ErrorCode.EXCEPTION_ERROR;

        if(isAjax(request)){
            log.error(LOG_HEADER + "exceptionHandler ajax 요청 처리 시작");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            ErrorResponseVo errorResponseVo = new ErrorResponseVo();
            errorResponseVo.setResultCode(errorCode.getCode());
            errorResponseVo.setResultMsg(errorCode.getMessage());
            //writer.write(new Gson().toJson(errorResponseVo));
//            log.error(LOG_HEADER + "exceptionHandler new Gson().toJson(errorResponseVo) : " + new Gson().toJson(errorResponseVo));
            //
//            writer.write(JSON.toJSONString(Result.errorOf(HttpStatus.NOT_FOUND.value(), e.getMessage())));
            //
            writer.flush();
            writer.close();
            log.error(LOG_HEADER + "exceptionHandler ajax 요청 처리 종료");

            return null;
        }else{
            log.error(LOG_HEADER + "bizExceptionHandler ajax 요청 처리 시작");
            model.addAttribute("errorStatus", errorCode.getStatus());
            model.addAttribute("errorCode", errorCode.getCode());
            model.addAttribute("errorMessage", errorCode.getMessage());
            model.addAttribute("activeProfile", activeProfile);
            model.addAttribute("exception", e);

            return "common/error/error";
        }


    }

    private boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With").toString()));
    }

}
