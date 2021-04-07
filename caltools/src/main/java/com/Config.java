package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * program:testspring
 * description:config
 * author:lsj
 * create:2021-04-05 09:40
 */
@Configuration
@ComponentScan(basePackages = {"com.huwei", "com.mimi"})
public class Config {
    @Bean
    public Random r() {
        return new Random();
    }
}
