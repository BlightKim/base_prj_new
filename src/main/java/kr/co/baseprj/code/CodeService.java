package kr.co.baseprj.code;

import kr.co.baseprj.code.vo.CodeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : CodeService
 * @since : 10/17/23
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CodeService {

  private final CodeDao codeDao;

  public CodeVO selectCode(CodeVO param) {

    return codeDao.selectCode(param);
  }
}
