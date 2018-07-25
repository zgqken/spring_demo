package com.ken;

import com.alibaba.fastjson.JSONObject;
import com.ken.spring.order.Car;
import com.ken.web.config.WebMvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/5/23 0023
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebMvcConfig.class})
public class BaseSpringTest {

    @Autowired
    private List<Car> car;

    @Autowired
    private Map<String,Car> carMap;

    @Test
    public void test(){
        System.out.println(JSONObject.toJSONString(carMap));
    }


}
