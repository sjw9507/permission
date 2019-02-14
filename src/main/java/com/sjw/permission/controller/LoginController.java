package com.sjw.permission.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.sjw.permission.common.constant.ControllerUrls.CLIENT_API_URI;

/**
 * @author sjw
 * @date 2019/2/14
 */

@Slf4j
public class LoginController {

    @Api(value = "Hello", tags = "Hello")
    @RestController
    @RequestMapping(CLIENT_API_URI)
    public class HelloController {
        @RequestMapping(value = "/hello", method = RequestMethod.GET)
        public String hello() {
            return "Hello World !";
        }
    }

}
