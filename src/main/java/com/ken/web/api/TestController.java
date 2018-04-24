package com.ken.web.api;

import com.alibaba.fastjson.JSONObject;
import com.ken.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zgquan(108563)
 * @date 2018/4/16 0016
 * @since
 */
@RestController
@RequestMapping(value = "/")
public class TestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/test")
    public void test(){
        System.out.println(JSONObject.toJSONString(userDao.getList()));
    }
}
