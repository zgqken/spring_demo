package com.ken.java8;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 *
 * @author：zgquan
 * @date：2017/11/2 0002
 */
public class LambdaDemo {

    public static void main(String[] args) {
  /*      ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
        System.out.println(threadLocal.get().format(new Date()));*/
/*
        BinaryOperator<Long> add = (x,y)->x+y;
        Long res = add.apply(12L,14L);
        System.out.println(res);*/

        List<Person> list = new ArrayList<>();
        list.add(new Person(12,"CN"));
        list.add(new Person(92,"CN"));
        list.add(new Person(37,"CN"));
        list.add(new Person(23,"JP"));
        list.add(new Person(13,"JP"));
        list.add(new Person(27,"JP"));

        Person person = list.stream().max(Comparator.comparing(person1 -> person1.getAge())).get();
        Set<String> sets= list.stream()
                .filter(person1 -> person1.getAge()>25)
                .map(Person::getContry)
                .collect(Collectors.toSet());

        System.out.println(JSONObject.toJSONString(sets));


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


class Person{

    public Person(int age, String contry) {
        this.age = age;
        this.contry = contry;
    }

    private int age;

    private String contry;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }
}
