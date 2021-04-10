package com.yc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * program:testspring
 * description:appconfig
 * author:lsj
 * create:2021-04-05 14:56
 */
@Configuration
@ComponentScan(basePackages = {"com.yc"})
@EnableAspectJAutoProxy
public class AppConfig {
}
