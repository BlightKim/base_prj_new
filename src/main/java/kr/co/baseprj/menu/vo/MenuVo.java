package kr.co.baseprj.menu.vo;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
public class MenuVo{
  private String menuCd;
  private String menuNm;
  private int depth;
  private String cateCd;
  private String dvsCd;
  private String sectCd;
  private int cateSort;
  private int dvsSort;
  private int sectSort;
  private String cateNm;
  private String dvsNm;
  private String sectNm;
  private String linkUrl;
  private String icon;
  private String displYn;

  private String selectType;

  private List<MenuVo> list;
  private List<PageVo> arrPage;

  // menuauth
  private String authGroupCd;
  private String viewType;


}