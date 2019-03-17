package com.sjw.permission.modules.sys.controller;

import com.sjw.permission.modules.sys.param.TestVo;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
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
    public String hello() {
        return "Hello World !";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(@Validated TestVo testVo) {
        return "Hello World !";
    }

}


