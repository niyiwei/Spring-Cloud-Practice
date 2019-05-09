package pers.phd.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Pundix055
 * @date 2019-01-19 09:58.
 */
@Controller
public class MainController {

    @GetMapping(path = {"", "/", "index"})
    public String index() {
        return "index";
    }

    @GetMapping(path = "/user/index")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(path = "/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping(path = "/401")
    public String accessDenied() {
        return "401";
    }
}
