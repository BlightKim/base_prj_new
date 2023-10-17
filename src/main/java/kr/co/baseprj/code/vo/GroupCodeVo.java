package kr.co.baseprj.code.vo;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class GroupCodeVo  {

    private String groupCd;
    private String groupCdNm;
    private String searchGroupCd;
    private String searchGroupCdNm;
    private String descrt;

    List<CodeVO> arrCode;
}
