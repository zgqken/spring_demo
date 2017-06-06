package com.ken.web.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/5/22 0022
 */
@Order(1)
public class DemoWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 将DispatcherServlet映射到 "/"
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 应用上下文，除web部分
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    /**
     * 指定配置类
     * 注册过滤器，映射路径与DispatcherServlet一致，路径不一致的过滤器需要注册到另外的WebApplicationInitializer中
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }
}
