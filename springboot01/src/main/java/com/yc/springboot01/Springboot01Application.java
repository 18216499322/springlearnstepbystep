package com.yc.springboot01;

import com.yc.service.HelloService;
import com.yc.service.IService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(Properties.class)
public class Springboot01Application {

    private static Log log = LogFactory.getLog(Springboot01Application.class);

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(Springboot01Application.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Springboot01Application.class, args);
    }

    @GetMapping("/boot01")
    public String boot01(@RequestParam(value = "name", defaultValue = "boot01") String name) {
        return String.format("name=%s", name);
    }

    @Autowired
    private IService service;

    @GetMapping("/boot02")
    public void boot02(@RequestParam(value = "name", defaultValue = "boot02") String name) {
        ((HelloService) service).say();
    }

    @Autowired
    private DataSource source;

    @GetMapping("/boot03")
    public String boot03(@RequestParam(value = "name", defaultValue = "boot03") String name) {
        log.debug("debug");
        log.error("error");
        log.fatal("fatal");
        log.info("info");

        System.out.println(env);
        System.out.println(jdbcurl);

        System.out.println(properties);
        return source.toString();
    }

    @Autowired
    private Environment env;

    @Value("${yc.datasource.jdbcurl}")
    private String jdbcurl;

    @Autowired
    private Properties properties;
}
