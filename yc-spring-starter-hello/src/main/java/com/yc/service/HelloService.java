package com.yc.service;

/**
 * program:testspring
 * description:helloservice
 * author:lsj
 * create:2021-04-22 21:06
 */
public class HelloService implements IService {

    private String name;
    private String content;

    public HelloService(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public void say() {
        System.out.println(name + "说" + content);
    }
}
