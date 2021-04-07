package com.yc.biz;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentBizTest {

    //    StudentBiz studentBiz;
    ApplicationContext context;

    @Before
    public void before() {
//        StudentDao studentDao = new StudentDaoimpl();
//        studentBiz = new StudentBiz(studentDao);
        context = new AnnotationConfigApplicationContext("com.yc.config");
        System.out.println(context);
    }

    @Test
    public void add() {
        StudentBiz biz = (StudentBiz) context.getBean("studentBiz");
        biz.add("张三");
    }

    @Test
    public void update() {
        StudentBiz biz = (StudentBiz) context.getBean("studentBiz");
        biz.update("张三");
    }
}