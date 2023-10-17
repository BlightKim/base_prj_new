package kr.co.baseprj.code.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CodeVO {

    private String groupCd;
   //  private String frmGroupCd;
    private String cd;
    private String cdNm;
    private String descrt;
    private int displSort;

}
