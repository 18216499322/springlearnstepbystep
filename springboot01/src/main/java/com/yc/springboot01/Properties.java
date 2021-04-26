package com.yc.springboot01;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * program:testspring
 * description:properties
 * author:lsj
 * create:2021-04-24 15:49
 */
@ConfigurationProperties(prefix = "yc.datasource")
public class Properties {
    private String driverclass;
    private String jdbcurl;

    @Override
    public String toString() {
        return "Properties{" +
                "driverclass='" + driverclass + '\'' +
                ", jdbcurl='" + jdbcurl + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setDriverclass(String driverclass) {
        this.driverclass = driverclass;
    }

    public void setJdbcurl(String jdbcurl) {
        this.jdbcurl = jdbcurl;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String user;

    public String getDriverclass() {
        return driverclass;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    private String password;
}
