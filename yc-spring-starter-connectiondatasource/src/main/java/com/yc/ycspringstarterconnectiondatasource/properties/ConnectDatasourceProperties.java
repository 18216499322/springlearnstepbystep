package com.yc.ycspringstarterconnectiondatasource.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * program:testspring
 * description:properties
 * author:lsj
 * create:2021-04-24 14:15
 */
@ConfigurationProperties(prefix = "yc.datasource")
public class ConnectDatasourceProperties {
    private String driveclass;
    private String jdbcurl;
    private String user;
    private String password;

    public void setDriveclass(String driveclass) {
        this.driveclass = driveclass;
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

    public String getDriveclass() {
        return driveclass;
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
}
