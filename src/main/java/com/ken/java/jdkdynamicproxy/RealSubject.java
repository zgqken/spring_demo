package com.ken.java.jdkdynamicproxy;

/**
 * @author：davy
 * @date：2018/7/25
 */
public class RealSubject implements Subject {

    @Override
    public String request(String name) {
        return "request-->"+name;
    }

    @Override
    public void print(String name) {
        System.out.println("print-->"+name);
    }

}
