package com.ken.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 类名称：
 * 类描述：VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * 创建人：zgquan
 * 创建日期：2017/7/14
 */
public class JavaMethodAreaOOM {


    public static void main(final String[] args) {
        int i=0;
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy
                        methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(objects,args);
                }
            });
            enhancer.create();
            System.out.println(i++);
        }
    }

    static class OOMObject{}
}
