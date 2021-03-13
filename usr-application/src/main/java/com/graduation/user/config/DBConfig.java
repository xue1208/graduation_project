package com.graduation.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author zhangxue
 * @date 2021.2.28
 */
@Configuration
@EnableTransactionManagement
public class DBConfig {
    @Value("${druid.username}")
    private String username;
    @Value("${druid.url}")
    private String url;
    @Value("${druid.password}")
    private String password;
    @Value("${druid.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource dateSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        System.out.println("数据源：username = " + username + " ，password = " + password);
        System.out.println("数据源是：" + dataSource.getConnection());
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){

        return new DataSourceTransactionManager(dataSource);
    }
}
