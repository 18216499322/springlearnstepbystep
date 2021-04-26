package com.yc.dao;

import com.yc.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class OpRecordDaoImplTest {
    @Autowired
    OpRecordDao opRecordDao;

    @Test
    public void saveOpRecord() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByAccountId() {
    }
}