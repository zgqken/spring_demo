package com.ken.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author：zgquan
 * @date：2017/11/2 0002
 */
public class LambdaDemo {

    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::collide);
    }

}

class Car{

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }
}
