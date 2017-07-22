package com.vabram.hearthum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by brama051 on 1.3.2017..
 */
@Controller
public class LoginController {


    private final static String LOGIN_VIEW_NAME="login";

    @RequestMapping("/login")
    private String login() {
        return LOGIN_VIEW_NAME;
    }
}
