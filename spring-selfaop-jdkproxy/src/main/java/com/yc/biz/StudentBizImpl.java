package com.yc.biz;

/**
 * program:testspring
 * description:studentbizimpl
 * author:lsj
 * create:2021-04-10 20:20
 */
public class StudentBizImpl implements StudentBiz {
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void find() {
        System.out.println("find");
    }
}
