package com.yc.dao;

import com.yc.AppConfig;
import com.yc.bean.Accounts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountsDaoImplTest {

    @Autowired
    @Qualifier("accountsDaoImpl")
    private AccountsDao dao;

    @Test
    public void saveAccount() {
        System.out.println(dao);
    }

    @Test
    public void updateAccount() {
    }

    @Test
    public void findAccount() {
    }

    @Test
    public void findAll() {
        List<Accounts> list = dao.findAll();
        System.out.println(list);
    }

    @Test
    public void delete() {
    }
}