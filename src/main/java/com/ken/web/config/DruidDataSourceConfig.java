package com.ken.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * @author zgquan(108563)
 * @date 2018/4/16 0016
 * @since
 */
@Configuration
@PropertySource({"classpath:config/jdbc.properties"})
public class DruidDataSourceConfig {

    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.password}")
    private String jdbcPassword;


    @Bean(destroyMethod = "close")
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(jdbcUrl);
        ds.setUsername(jdbcUserName);
        ds.setPassword(jdbcPassword);

        ds.setInitialSize(1);
        ds.setMinIdle(1);
        ds.setMaxActive(20);
        ds.setMaxWait(60000);
        ds.setTimeBetweenEvictionRunsMillis(60000);
        ds.setMinEvictableIdleTimeMillis(300000);

        ds.setValidationQuery("SELECT 'x'");
        ds.setTestWhileIdle(true);
        ds.setTestOnBorrow(false);
        ds.setTestOnReturn(false);

        ds.setPoolPreparedStatements(true);
        ds.setMaxPoolPreparedStatementPerConnectionSize(20);
        ds.setFilters("stat");

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws SQLException {
        return new JdbcTemplate(dataSource());
    }
}
