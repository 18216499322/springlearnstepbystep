package com.yc.biz;

import org.springframework.stereotype.Service;

/**
 * program:testspring
 * description:studentbiz
 * author:lsj
 * create:2021-04-09 19:22
 */
@Service
public interface StudentBiz {
    public void add(String name);

    public void update(String name);

    public void find(String name);
}
