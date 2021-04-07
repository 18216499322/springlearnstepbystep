package com.yc.dao;

import org.springframework.stereotype.Component;

/**
 * program:testspring
 * description:studentDaoImpl
 * author:lsj
 * create:2021-04-04 14:48
 */
@Component
public class StudentDaoimpl implements StudentDao {
    @Override
    public int add(String name) {
        System.out.println("添加学生" + name);
        return 1;
    }

    @Override
    public void update(String name) {
        System.out.println("更新学生" + name);
    }
}
