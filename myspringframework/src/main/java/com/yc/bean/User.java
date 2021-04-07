package com.yc.bean;

import com.yc.myspringframework.stereotype.MyRepository;

/**
 * program:testspring
 * description:user
 * author:lsj
 * create:2021-04-07 11:22
 */
@MyRepository
public class User {
    String name = "张三";
    int age = 18;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
