package com.ken.spring.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author：davy
 * @date：2018/7/6
 */
@Component
@Order(1)
public class RedCar implements Car {
    public String color = "red";

    @Override
    public void getColor() {
        System.out.println("red car");
    }
}
