package com.ken.java.jdkdynamicproxy;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @author：davy
 * @date：2018/7/25
 */
public class CglibMain {

    public static void main(String[] args) {
        Enhancer enchaner = new Enhancer();
        //设置被代理的类
        enchaner.setSuperclass(RealSubject.class);
        //创建一个回调接口
        Callback interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                    throws Throwable {
                System.out.println("代理方法:" + method.getName());
                System.out.println("方法执行前调用");
                Object object = proxy.invokeSuper(obj, args);
                System.out.println("方法执行后调用");
                return object;
            }
        };
        CallbackFilter callbackFilter = new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if ("request".equals(method.getName())) {
                    System.out.println("不进行代理的方法:"+method.getName());
                    return 1;
                }
                return 0;
            }
        };
        Callback[] callbacks = new Callback[]{interceptor, NoOp.INSTANCE};
        enchaner.setCallbackFilter(callbackFilter);
        enchaner.setCallbacks(callbacks);
        RealSubject student = (RealSubject) enchaner.create();
        //执行方法调用
        System.out.println(student.request("test"));
        student.print("test");

    }
}
