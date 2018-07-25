package com.ken.spring.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author：davy
 * @date：2018/7/6
 */
@Component
@Order(10)
public class BlackCar implements Car {

    public String color="black";

    @Override
    public void getColor() {
        System.out.println("black car");
    }
}
