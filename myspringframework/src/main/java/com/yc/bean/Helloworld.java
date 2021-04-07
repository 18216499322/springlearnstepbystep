package com.yc.bean;

import com.yc.myspringframework.stereotype.MyAutowired;
import com.yc.myspringframework.stereotype.MyComponent;
import com.yc.myspringframework.stereotype.MyPostConstruct;
import com.yc.myspringframework.stereotype.MyPreDestory;

/**
 * program:testspring
 * description:helloworld
 * author:lsj
 * create:2021-04-05 14:31
 */
@MyComponent()
public class Helloworld {
    @MyAutowired
    public void setUser(User user) {
        this.user = user;
    }

    @MyAutowired
    User user;

    public Helloworld() {
        System.out.println("构造函数");
    }

    @MyPostConstruct
    public void postConstruct() {
        System.out.println("构造之后");
    }

    @Override
    public String toString() {
        return "Helloworld{" +
                "user=" + user +
                '}';
    }

    @MyPreDestory
    public void preDestory() {
        System.out.println("销毁之前");
    }

    public void sayHello() {
        System.out.println("HelloWorld");
    }
}
