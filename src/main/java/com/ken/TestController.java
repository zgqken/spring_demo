package com.ken;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：davy(888032)
 * @date：2018/1/1
 * @since
 */
@RestController
@RequestMapping()
public class TestController {

    @Value("${jdbc.password}")
    private String password;

    @RequestMapping(value = "test")
    public void test(){
        System.out.println("test success");
        System.out.println(password);
    }
}
