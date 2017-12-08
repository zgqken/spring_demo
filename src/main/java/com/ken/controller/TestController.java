package com.ken.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zgquan(108563)
 * @date 2017/12/8 0008
 * @since
 */
@RestController
@RequestMapping
public class TestController {

    /**
     * 测试输出HelloWord
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "HelloWord";
    }
}
