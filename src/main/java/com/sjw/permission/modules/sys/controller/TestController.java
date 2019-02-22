package com.sjw.permission.modules.sys.controller;

import com.sjw.permission.modules.sys.pto.GroupPto;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sjw
 * @date 2019/2/14
 */

@Api(value = "Test", tags = "Test")
@RestController
public class TestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@Validated @RequestBody GroupPto groupPto) {
        return "Hello World !";
    }
}


