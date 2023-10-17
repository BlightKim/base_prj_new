package kr.co.baseprj.menu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : MenuController
 * @since : 10/17/23
 */
@Controller
@RequestMapping("/menu")
@Slf4j
@RequiredArgsConstructor
public class MenuController {
  private static final String LOG_HEADER = "[메뉴 컨트롤러]";

  private final MenuService menuService;

  @GetMapping("/list")
  public String view(Model model) {
    log.info("menu view start");

    return "mgmt/menu/menu";
  }
}
