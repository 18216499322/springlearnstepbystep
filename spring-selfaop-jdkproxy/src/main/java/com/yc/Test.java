package com.yc;

import com.yc.biz.StudentBiz;
import com.yc.biz.StudentBizImpl;

/**
 * program:testspring
 * description:test
 * author:lsj
 * create:2021-04-10 20:27
 */
public class Test {
    public static void main(String[] args) {
        StudentBiz biz = new StudentBizImpl();
        LogAspect logAspect = new LogAspect(biz);
        Object o = logAspect.createProxy();
        if (o instanceof StudentBiz) {
            StudentBiz biz1 = (StudentBiz) o;
            biz1.add();
            biz1.update();
            biz1.find();
        }
        System.out.println(o);
    }
}
