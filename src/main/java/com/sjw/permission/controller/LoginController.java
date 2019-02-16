package com.sjw.permission.controller;

import com.sjw.permission.pto.GroupPto;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.sjw.permission.common.constant.ControllerUrls.CLIENT_API_URI;

/**
 * @author sjw
 * @date 2019/2/14
 */

@Api(value = "Hello", tags = "Hello")
@RestController
public class LoginController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@Validated GroupPto groupPto) {
        return "Hello World !";
    }
}


