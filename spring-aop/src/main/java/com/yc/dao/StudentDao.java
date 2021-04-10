package com.yc.dao;

import org.springframework.stereotype.Repository;

/**
 * program:testspring
 * description:studentdao
 * author:lsj
 * create:2021-04-09 19:19
 */
@Repository
public interface StudentDao {
    public void add(String name);

    public void update(String name);

    public void find(String name);
}
