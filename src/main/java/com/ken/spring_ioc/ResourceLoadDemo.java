package com.ken.spring_ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/8/14 0014
 */
public class ResourceLoadDemo {
    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

    }
}
