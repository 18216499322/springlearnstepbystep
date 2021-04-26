package com.yc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * program:testspring
 * description:swagger2
 * author:lsj
 * create:2021-04-26 19:25
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${swagger.enable}")
    private boolean isEnable;

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .enable(isEnable)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.yc"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("银行存取转账接口文档")
                .contact(new Contact("lsj", "http://www.baidu.com",
                        "718261933@qq.com"))
                .version("2.9.2")
                .build();
    }
}
