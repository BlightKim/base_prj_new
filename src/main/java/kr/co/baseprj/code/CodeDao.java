package kr.co.baseprj.code;

import kr.co.baseprj.code.vo.CodeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : CodeDao
 * @since : 10/17/23
 */
@Repository
@Slf4j
@RequiredArgsConstructor
public class CodeDao {
  private static final String NAME_SPACE = "kr.co.baseprj.code.CodeDao";

  private final SqlSession sqlSession;


  public CodeVO selectCode(CodeVO param) {
    return sqlSession.selectOne(NAME_SPACE + "selectCode", param);
  }
}
