package com.yc.dao;

import org.springframework.stereotype.Component;

/**
 * program:testspring
 * description:studentdao
 * author:lsj
 * create:2021-04-04 14:47
 */
@Component
public interface StudentDao {
    public int add(String name);

    public void update(String name);
}
