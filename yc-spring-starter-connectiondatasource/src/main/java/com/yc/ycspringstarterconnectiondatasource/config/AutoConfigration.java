package com.yc.ycspringstarterconnectiondatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yc.ycspringstarterconnectiondatasource.properties.ConnectDatasourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * program:testspring
 * description:autoconfigration
 * author:lsj
 * create:2021-04-24 14:14
 */
@Configuration
@EnableConfigurationProperties(ConnectDatasourceProperties.class)
@ConditionalOnProperty(prefix = "yc", name = "isopen", havingValue = "true")
public class AutoConfigration {
    @Autowired
    private ConnectDatasourceProperties properties;

    @Bean
    public DataSource dataSources() throws PropertyVetoException {
        DataSource ds = new ComboPooledDataSource();
        ((ComboPooledDataSource) ds).setDriverClass(properties.getDriveclass());
        ((ComboPooledDataSource) ds).setJdbcUrl(properties.getJdbcurl());
        ((ComboPooledDataSource) ds).setUser(properties.getUser());
        ((ComboPooledDataSource) ds).setPassword(properties.getPassword());
        return ds;
    }

    @Bean
    @Profile(value = {"prod"})
    public DataSource dataSources2() throws PropertyVetoException {
        DataSource ds = new DruidDataSource();
        ((DruidDataSource) ds).setDriverClassName(properties.getDriveclass());
        ((DruidDataSource) ds).setUrl(properties.getJdbcurl());
        ((DruidDataSource) ds).setUsername(properties.getUser());
        ((DruidDataSource) ds).setPassword(properties.getPassword());
        return ds;
    }
}
