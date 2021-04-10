package com.yc.dao;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * program:testspring
 * description:studentdaoimpl
 * author:lsj
 * create:2021-04-09 19:20
 */
@Repository
public class StudentDaoImpl implements StudentDao {
    @Override
    public void add(String name) {
        System.out.println("add");
    }

    @Override
    public void update(String name) {
        System.out.println("update");
    }

    @Override
    public void find(String name) {
        System.out.println("find...");
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
