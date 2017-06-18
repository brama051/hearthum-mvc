package com.vabram.hearthum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by brama051 on 27.2.2017..
 */
@Controller
public class DashboardController {

    private static final String DASHBOARD_VIEW_NAME = "dashboard";
    @RequestMapping({"/", "/index"})
    public String index() {
        return DASHBOARD_VIEW_NAME;
    }


}
