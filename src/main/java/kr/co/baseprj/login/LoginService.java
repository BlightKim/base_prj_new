package kr.co.baseprj.login;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import kr.co.baseprj.common.utils.SHAUtils;
import kr.co.baseprj.common.utils.StringUtils;
import kr.co.baseprj.common.utils.UserSessUtil;
import kr.co.baseprj.mgmt.userMgmt.UserDao;
import kr.co.baseprj.mgmt.userMgmt.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : LoginService
 * @since : 10/17/23
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
  private final UserDao userDao;
  private static final String LOG_HEADER = "[관리자 관리 서비스] ";

  public HashMap<String, Object> loginProc(UserVo param, HttpServletRequest request) throws Exception {
    HashMap<String, Object> result = new HashMap<>();

    UserVo userVo = userDao.findUserByUserId(param.getUserId());

    if(userVo != null) {

      if (!StringUtils.isEmpty(param.getSecretNum())) {
        param.setSecretNum(param.getSecretNum());
      }

      log.debug("password : {}", param.getSecretNum());

      if (param.getSecretNum().equals(userVo.getSecretNum())) {
        UserSessUtil.getNewSess(request);
        UserSessUtil.setUserId(request, userVo.getUserId());
        UserSessUtil.setUserNm(request,userVo.getUserNm());
        UserSessUtil.setAuthGroupCd(request, userVo.getAuthGroupCd());
        UserSessUtil.setUserVo(request, userVo);

        result.put("resultCd", "0000");
        result.put("resultMsg", "");
      } else {
        result.put("resultCd", "1000");
        result.put("resultMsg", "아이디와 비밀번호를 확인해주세요.");
      }
    }
    log.info(LOG_HEADER + "결과 : " + result.toString());
    return result;
  }
}
