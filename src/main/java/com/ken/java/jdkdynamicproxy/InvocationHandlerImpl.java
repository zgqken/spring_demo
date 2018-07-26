package com.ken.java.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author：davy
 * @date：2018/7/25
 */
public class InvocationHandlerImpl implements InvocationHandler {

    /**
     * 要代理的真实对象
     */
    private Object subject;

    /**
     * 构造方法，给我们要代理的真实对象赋初值
     * @param subject
     */
    public InvocationHandlerImpl(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象前添加自定义操作
        System.out.println("在调用真实对象之前");
        System.out.println("Method:" + method);
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object returnValue = method.invoke(subject, args);
        //在代理真实对象后添加自定义操作
        System.out.println("在调用真实对象之后");
        return returnValue;
    }
}
