package kr.co.baseprj.login;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import kr.co.baseprj.common.utils.UserSessUtil;
import kr.co.baseprj.mgmt.userMgmt.UserService;
import kr.co.baseprj.mgmt.userMgmt.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : LoginController
 * @since : 10/17/23
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
  private final LoginService loginService;
  private final UserService userService;

  @GetMapping("/")
  public String adminInit(HttpServletRequest request, Model model) {
    log.debug("root path start : {}", UserSessUtil.isLoggedIn(request));

    if (UserSessUtil.isLoggedIn(request)) {
      return "redirect:/userList";
    } else {
      return "redirect:/system/login";
    }
  }

  @GetMapping("/system/login")
  public String login(Model model, HttpServletRequest request) {

    String url = request.getParameter("url");
    log.info("결과 : {}", url);
    model.addAttribute("url", url);

    return "/system/login/login";
  }
  @PostMapping("/system/loginProc")
  @ResponseBody
  public HashMap<String, Object> loginProc(UserVo userVo, HttpServletRequest request)
      throws Exception {
    log.info("결과 : {}", userVo.toString());
    return loginService.loginProc(userVo, request);
  }
}
