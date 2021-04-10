package com.yc.biz;

import com.yc.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentBizImplTest {

    @Autowired
    @Qualifier("studentBizImpl")
    StudentBiz biz;

    @Test
    public void add() {
        biz.add("张三");
    }

    @Test
    public void update() {
        biz.update("张三");
    }

    @Test
    public void find() {
        biz.find("张三");
    }
}