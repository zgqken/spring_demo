package com.ken.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：davy(888032)
 * @date：2017/12/31
 * @since
 */
@RestController
@RequestMapping("")
public class WechaController {

    @RequestMapping("/test")
    public void test(){
        System.out.println("test");
    }
}
