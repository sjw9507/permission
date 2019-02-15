package com.sjw.permission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sjw
 * @date 2019/2/15
 */

@Controller
@RequestMapping("/sys/group")
public class GroupController {
    @RequestMapping("/group.page")
    public ModelAndView page() {
        return new ModelAndView("group");
    }
}
