package com.ken.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/7/22
 */
public class IoCTest {

    public static void main(String[] args) {
        //BeanDefinition
        ClassPathResource res = new ClassPathResource("beans.xml");
        //beanfactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //BeanDefinition 的读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        //bean的载入和注册
        reader.loadBeanDefinitions(res);
    }
}
