package com.yc.biz;

import com.yc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * program:testspring
 * description:studentbizimpl
 * author:lsj
 * create:2021-04-09 19:23
 */
@Service
public class StudentBizImpl implements StudentBiz {

    @Autowired
    private StudentDao dao;

    @Override
    public void add(String name) {
        dao.add("张三");
    }

    @Override
    public void update(String name) {
        dao.update("张三");
    }

    @Override
    public void find(String name) {
        dao.find("张三");
    }
}
