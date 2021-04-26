package com.yc.config;

import com.yc.properties.HelloProperties;
import com.yc.service.HelloService;
import com.yc.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * program:testspring
 * description:helloautoconfigration
 * author:lsj
 * create:2021-04-22 21:11
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnProperty(prefix = "yc", name = "isopen", havingValue = "true")
public class HelloAutoConfigration {
    @Autowired
    private HelloProperties properties;

    @Bean
    public IService helloService() {
        return new HelloService(properties.getName(), properties.getContent());
    }
}
