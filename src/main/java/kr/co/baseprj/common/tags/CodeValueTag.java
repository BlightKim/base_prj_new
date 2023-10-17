package kr.co.baseprj.common.tags;


import kr.co.baseprj.code.CodeService;
import kr.co.baseprj.code.vo.CodeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;


/**
 * 공통코드명값 가져오기
 *
 * @author 인텔리진
 */
public class CodeValueTag extends RequestContextAwareTag {

    private static final long serialVersionUID = -7711494200550467974L;

    private String grpCd;
    private String cd;

    @Autowired
    private CodeService codeService;

    private static final Logger logger = LoggerFactory.getLogger(CodeValueTag.class);

    @Override
    protected int doStartTagInternal() throws Exception {
        if (codeService == null) {
            // WebApplicationContext 를 얻는다.
            WebApplicationContext ctx = getRequestContext().getWebApplicationContext();
            codeService = ctx.getBean(CodeService.class);
        }



        try {

            String cdName = "";

            CodeVO param = new CodeVO();
            param.setGroupCd(grpCd);
            param.setCd(cd);

            CodeVO cdValue = codeService.selectCode(param);

            String cdNm = "";

            if (cdValue != null) {
                cdNm = cdValue.getCdNm();
            }

            //logger.debug("[공통코드 셀렉트 박스 태그] 생성 결과 : " + sb.toString());

            pageContext.getOut().write(cdNm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    public void setGrpCd(String grpCd) {
        this.grpCd = grpCd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

}