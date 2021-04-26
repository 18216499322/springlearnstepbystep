package com.yc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * program:testspring
 * description:helloproperties
 * author:lsj
 * create:2021-04-22 21:04
 */
@ConfigurationProperties(prefix = "yc.starter")
public class HelloProperties {
    private String name;
    private String content;

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
