package com.yc.test;

import com.yc.AppConfig;
import com.yc.bean.Helloworld;
import com.yc.myspringframework.MyApplicationContext;

/**
 * program:testspring
 * description:testhello
 * author:lsj
 * create:2021-04-05 14:35
 */
public class TestHello {
    public static void main(String[] args) throws Exception {
        MyApplicationContext context = new MyAnnotationConfigApplicationContext(AppConfig.class);
        Helloworld helloworld = (Helloworld) context.getBean("helloworld");
        helloworld.sayHello();
        System.out.println(helloworld);
    }
}
