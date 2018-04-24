package com.ken.web.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/3/29 0029
 */
//@Configuration
//@PropertySource({"classpath:config/jdbc.properties"})
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${c3p0.acquireIncrement}")
    private int acquireIncrement;
    @Value("${c3p0.initialPoolSize}")
    private int initialPoolSize;
    @Value("${c3p0.minPoolSize}")
    private int minPoolSize;
    @Value("${c3p0.maxPoolSize}")
    private int maxPoolSize;
    @Value("${c3p0.maxIdleTime}")
    private int maxIdleTime;

    @Value("${c3p0.idleConnectionTestPeriod}")
    private int idleConnectionTestPeriod;
    @Value("${c3p0.maxStatements}")
    private int maxStatements;
    @Value("${c3p0.numHelperThreads}")
    private int numHelperThreads;
    @Value("${c3p0.checkoutTimeout}")
    private int checkoutTimeout;
    @Value("${c3p0.validate}")
    private boolean validate;
    @Value("${c3p0.testConnectionOnCheckout}")
    private boolean testConnectionOnCheckout;
    @Value("${c3p0.preferredTestQuery}")
    private String preferredTestQuery;


    @Bean(destroyMethod="close")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();

        ds.setDriverClass(jdbcDriver);
        ds.setJdbcUrl(jdbcUrl);
        ds.setUser(jdbcUserName);
        ds.setPassword(jdbcPassword);

        ds.setInitialPoolSize(initialPoolSize);
        ds.setMinPoolSize(minPoolSize);
        ds.setMaxPoolSize(maxPoolSize);
        ds.setAcquireIncrement(acquireIncrement);
        ds.setMaxIdleTime(maxIdleTime);

        ds.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
        ds.setCheckoutTimeout(checkoutTimeout);
        ds.setMaxStatements(maxStatements);
        ds.setNumHelperThreads(numHelperThreads);
        ds.setTestConnectionOnCheckout(testConnectionOnCheckout);
        ds.setPreferredTestQuery(preferredTestQuery);

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }

}
