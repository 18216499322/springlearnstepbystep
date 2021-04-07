package com.yc.biz;

import com.yc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * program:testspring
 * description:studentbiz
 * author:lsj
 * create:2021-04-04 14:46
 */
@Component()
public class StudentBiz {
    public StudentBiz() {
    }

    @Autowired()
    @Qualifier("studentDaoimpl2")
//    @Inject
//    @Named("studentDaoimpl")
    @Resource(name = "studentDaoimpl")
    StudentDao studentDao;

    public int add(String name) {
        return studentDao.add(name);
    }

    public void update(String name) {
        studentDao.update(name);
    }
}
