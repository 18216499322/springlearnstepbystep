package com.yc.config;

import com.yc.dao.StudentDao;
import com.yc.dao.StudentDaoimpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * program:testspring
 * description:config
 * author:lsj
 * create:2021-04-04 15:21
 */
@Configuration
@ComponentScan("com.yc")
public class Config {
    @Bean
    public StudentDao studentDaoimpl() {
        return new StudentDaoimpl();
    }
}
