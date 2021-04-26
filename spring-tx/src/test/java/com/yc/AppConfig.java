package com.yc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * program:testspring
 * description:appconfig
 * author:lsj
 * create:2021-04-14 20:16
 */
@Configuration
@ComponentScan(basePackages = "com.yc")
public class AppConfig {
    @Bean
    public DataSource dataSources() throws PropertyVetoException {
        DataSource ds = new ComboPooledDataSource();
        ((ComboPooledDataSource) ds).setDriverClass("com.mysql.cj.jdbc.Driver");
        ((ComboPooledDataSource) ds).setJdbcUrl("jdbc:mysql://localhost:3306/db_testbank?serverTimezone=GMT%2B8");
        ((ComboPooledDataSource) ds).setUser("root");
        ((ComboPooledDataSource) ds).setPassword("a");
        return ds;
    }
}
